package com.dnu.loi.smartrm.service;

import android.support.annotation.NonNull;
import android.util.Log;

import com.dnu.loi.smartrm.common.ETableSync;
import com.dnu.loi.smartrm.database.Dal;
import com.dnu.loi.smartrm.database.DalException;
import com.dnu.loi.smartrm.entity.Dishes;
import com.dnu.loi.smartrm.entity.DishesType;
import com.dnu.loi.smartrm.entity.Floor;
import com.dnu.loi.smartrm.entity.Menu;
import com.dnu.loi.smartrm.entity.MenuDetail;
import com.dnu.loi.smartrm.entity.Order;
import com.dnu.loi.smartrm.entity.OrderDetail;
import com.dnu.loi.smartrm.entity.Table;
import com.dnu.loi.smartrm.entity.TableSync;
import com.dnu.loi.smartrm.entity.TableType;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.dnu.loi.smartrm.common.ETableSync.DISHES;
import static com.dnu.loi.smartrm.common.ETableSync.DISHES_TYPE;
import static com.dnu.loi.smartrm.common.ETableSync.FLOOR;
import static com.dnu.loi.smartrm.common.ETableSync.MENU;
import static com.dnu.loi.smartrm.common.ETableSync.ORDER;
import static com.dnu.loi.smartrm.common.ETableSync.TABLE;
import static com.dnu.loi.smartrm.common.ETableSync.TABLE_TYPE;

/**
 * Mô tả:
 * <p>
 * Created by loi on 03/05/2018.
 */

public class SynchronizeController {
    private List<TableSync> tableSyncs;
    private static SynchronizeController INSTANCE;

    private SynchronizeController() {
    }

    public static SynchronizeController getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new SynchronizeController();
        }
        try {
            INSTANCE.tableSyncs = Dal.getInstance().getAll(TableSync.class);
        } catch (DalException e) {
            e.printStackTrace();
        }
        return INSTANCE;
    }

    public void startDownloadQueue(OnDownloadFinish callback) {
        if (callback != null) {
            synchronizeDishesType(() -> synchronizeDishes(
                    () -> synchronizeFloor(
                            () -> synchronizeTableType(
                                    () -> synchronizeTable(
                                            () -> synchronizeOrder(
                                                    () -> synchronizeMenu(callback)
                                            )
                                    )
                            )
                    )
                    )
            );
        }
    }

    public void synchronizeOrder(OnDownloadFinish listener) {
        //nếu không cần đồng bộ
        if (!getTableNeedSynchronized(ORDER)) {
            listener.onDone();
            return;
        }
        ApiUtils.getAPIService().getOrders().enqueue(new Callback<List<Order>>() {
            @Override
            public void onResponse(@NonNull Call<List<Order>> call, @NonNull Response<List<Order>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    try {
                        for (Order order : response.body()) {
                            Dal.getInstance().saveWithOnConflict(order, Order.class);
                            if (order.getDetails() != null) {
                                for (OrderDetail detail : order.getDetails()) {
                                    Dal.getInstance().saveWithOnConflict(detail, OrderDetail.class);
                                    Log.d("synchronizeOrder", "thêm " + detail.getName());
                                }
                            }
                            updateTableSyncState(ORDER, false);
                            Log.d("synchronizeOrder", "thêm " + order.getNote());
                        }
                    } catch (DalException e) {
                        updateTableSyncState(ORDER, true);
                        Log.d("synchronizeOrder", "lỗi không thể lưu vào database");
                    }
                } else{
                    updateTableSyncState(ORDER, true);
                    Log.d("synchronizeOrder", "lỗi api không trả về");
                }
                listener.onDone();
            }

            @Override
            public void onFailure(@NonNull Call<List<Order>> call, @NonNull Throwable t) {
                Log.d("synchronizeTable", "lỗi kết nối đến server");
                updateTableSyncState(ORDER, true);
            }
        });
    }

    public void synchronizeMenu(OnDownloadFinish listener) {
        //nếu không cần đồng bộ
        if (!getTableNeedSynchronized(MENU)) {
            listener.onDone();
            return;
        }
        ApiUtils.getAPIService().getMenus().enqueue(new Callback<List<Menu>>() {
            @Override
            public void onResponse(@NonNull Call<List<Menu>> call, @NonNull Response<List<Menu>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    try {
                        for (Menu menu : response.body()) {
                            Dal.getInstance().saveWithOnConflict(menu, Menu.class);
                            if (menu.getDetails() != null) {
                                for (MenuDetail detail : menu.getDetails()) {
                                    Dal.getInstance().saveWithOnConflict(detail, MenuDetail.class);
                                    Log.d("synchronizeMenu", "thêm " + detail.getDishesId());
                                }
                            }
                            updateTableSyncState(MENU, false);
                            Log.d("synchronizeMenu", "thêm " + menu.getName());
                        }
                    } catch (DalException e) {
                        updateTableSyncState(MENU, true);
                        Log.d("synchronizeMenu", "lỗi không thể lưu vào database");
                    }
                } else{
                    Log.d("synchronizeMenu", "lỗi api không trả về");
                    updateTableSyncState(MENU, true);
                }
                listener.onDone();
            }

            @Override
            public void onFailure(@NonNull Call<List<Menu>> call, @NonNull Throwable t) {
                Log.d("synchronizeTable", "lỗi kết nối đến server");
                updateTableSyncState(MENU, true);
            }
        });
    }

    public void synchronizeTable(OnDownloadFinish listener) {
        //nếu không cần đồng bộ
        if (!getTableNeedSynchronized(TABLE)) {
            listener.onDone();
            return;
        }
        ApiUtils.getAPIService().getTables().enqueue(new Callback<List<Table>>() {
            @Override
            public void onResponse(@NonNull Call<List<Table>> call, @NonNull Response<List<Table>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    try {
                        for (Table table : response.body()) {
                            Dal.getInstance().saveWithOnConflict(table, Table.class);
                            Log.d("synchronizeTable", "thêm " + table.getName());
                        }
                        updateTableSyncState(TABLE, false);
                    } catch (DalException e) {
                        Log.d("synchronizeTable", "lỗi không thể lưu vào database");
                        updateTableSyncState(TABLE, true);
                    }
                } else{
                    Log.d("synchronizeTable", "lỗi api không trả về");
                    updateTableSyncState(TABLE, true);
                }
                listener.onDone();
            }

            @Override
            public void onFailure(@NonNull Call<List<Table>> call, @NonNull Throwable t) {
                Log.d("synchronizeTable", "lỗi kết nối đến server");
                updateTableSyncState(TABLE, true);
            }
        });
    }

    public void synchronizeTableType(OnDownloadFinish listener) {
        //nếu không cần đồng bộ
        if (!getTableNeedSynchronized(TABLE_TYPE)) {
            listener.onDone();
            return;
        }
        ApiUtils.getAPIService().getTableTypes().enqueue(new Callback<List<TableType>>() {
            @Override
            public void onResponse(@NonNull Call<List<TableType>> call, @NonNull Response<List<TableType>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    try {
                        for (TableType type : response.body()) {

                            Dal.getInstance().saveWithOnConflict(type, TableType.class);
                            Log.d("synchronizeTableType", "thêm " + type.getName());
                        }
                        updateTableSyncState(TABLE_TYPE, false);
                    } catch (DalException e) {
                        Log.d("synchronizeTableType", "lỗi không thể lưu vào database");
                        updateTableSyncState(TABLE_TYPE, true);
                    }
                } else{
                    Log.d("synchronizeTableType", "lỗi api không trả về");
                    updateTableSyncState(TABLE_TYPE, true);
                }
                listener.onDone();
            }

            @Override
            public void onFailure(@NonNull Call<List<TableType>> call, @NonNull Throwable t) {
                Log.d("synchronizeTableType", "lỗi kết nối đến server");
                updateTableSyncState(TABLE_TYPE, true);
            }
        });
    }

    public void synchronizeFloor(OnDownloadFinish listener) {
        //nếu không cần đồng bộ
        if (!getTableNeedSynchronized(FLOOR)) {
            listener.onDone();
            return;
        }
        ApiUtils.getAPIService().getFloors().enqueue(new Callback<List<Floor>>() {
            @Override
            public void onResponse(@NonNull Call<List<Floor>> call, @NonNull Response<List<Floor>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    try {
                        for (Floor floor : response.body()) {

                            Dal.getInstance().saveWithOnConflict(floor, Floor.class);
                            Log.d("synchronizeFloor", "thêm " + floor.getName());
                        }
                        updateTableSyncState(FLOOR, false);
                    } catch (DalException e) {
                        Log.d("synchronizeFloor", "lỗi không thể lưu vào database");
                        updateTableSyncState(FLOOR, true);
                    }
                } else{
                    Log.d("synchronizeFloor", "lỗi api không trả về");
                    updateTableSyncState(FLOOR, true);
                }

                listener.onDone();
            }

            @Override
            public void onFailure(@NonNull Call<List<Floor>> call, @NonNull Throwable t) {
                Log.d("synchronizeFloor", "lỗi kết nối đến server");
                updateTableSyncState(FLOOR, true);
            }
        });
    }

    public void synchronizeDishes(OnDownloadFinish listener) {
        //nếu không cần đồng bộ
        if (!getTableNeedSynchronized(DISHES)) {
            listener.onDone();
            return;
        }
        ApiUtils.getAPIService().getDishes().enqueue(new Callback<List<Dishes>>() {
            @Override
            public void onResponse(@NonNull Call<List<Dishes>> call, @NonNull Response<List<Dishes>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    try {
                        for (Dishes dishes : response.body()) {
                            Dal.getInstance().saveWithOnConflict(dishes, Dishes.class);
                            Log.d("synchronizeDishes", "thêm " + dishes.getName());
                        }
                        updateTableSyncState(DISHES, false);
                    } catch (DalException e) {
                        Log.d("synchronizeDishes", "lỗi không thể lưu vào database");
                        updateTableSyncState(DISHES, true);
                    }
                } else{
                    Log.d("synchronizeDishes", "lỗi api không trả về");
                    updateTableSyncState(DISHES, true);
                }

                listener.onDone();
            }

            @Override
            public void onFailure(@NonNull Call<List<Dishes>> call, @NonNull Throwable t) {
                Log.d("synchronizeDishes", "lỗi kết nối đến server");
                updateTableSyncState(DISHES, true);
            }
        });
    }

    public void synchronizeDishesType(OnDownloadFinish listener) {
        //nếu không cần đồng bộ
        if (!getTableNeedSynchronized(DISHES_TYPE)) {
            listener.onDone();
            return;
        }
        ApiUtils.getAPIService().getDishesType().enqueue(new Callback<List<DishesType>>() {
            @Override
            public void onResponse(@NonNull Call<List<DishesType>> call, @NonNull Response<List<DishesType>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    try {
                        for (DishesType type : response.body()) {

                            Dal.getInstance().saveWithOnConflict(type, DishesType.class);
                            Log.d("synchronizeDishesType", "thêm " + type.getName());
                        }
                        updateTableSyncState(DISHES_TYPE, false);
                    } catch (DalException e) {
                        Log.d("synchronizeDishesType", "lỗi không thể lưu vào database");
                        updateTableSyncState(DISHES_TYPE, true);
                    }
                } else{
                    Log.d("synchronizeDishesType", "lỗi api không trả về");
                    updateTableSyncState(DISHES_TYPE, true);
                }

                listener.onDone();
            }

            @Override
            public void onFailure(@NonNull Call<List<DishesType>> call, @NonNull Throwable t) {
                Log.d("synchronizeDishesType", "lỗi kết nối đến server");
                updateTableSyncState(DISHES_TYPE, true);
            }
        });
    }

    /**
     * Cập nhật lại trạng thái của bảng sau khi đã đồng bộ
     *
     * @param tableSync bảng cần câp nhất
     * @param isSync    có cần cập nhật hay
     */
    private void updateTableSyncState(ETableSync tableSync, boolean isSync) {
        try {

            TableSync table = ORDER.getTableSync(isSync);

            switch (tableSync) {
                case MENU:
                    table = MENU.getTableSync(isSync);
                    break;
                case FLOOR:
                    table = FLOOR.getTableSync(isSync);

                    break;
                case ORDER:
                    table = ORDER.getTableSync(isSync);

                    break;
                case TABLE:
                    table = TABLE.getTableSync(isSync);

                    break;
                case DISHES:
                    table = DISHES.getTableSync(isSync);

                    break;
                case TABLE_TYPE:
                    table = TABLE_TYPE.getTableSync(isSync);

                    break;
                case DISHES_TYPE:
                    table = DISHES_TYPE.getTableSync(isSync);

                    break;
            }
            Dal.getInstance().saveWithOnConflict(table, TableSync.class);
        } catch (DalException e1) {
            e1.printStackTrace();
        }
    }

    private boolean getTableNeedSynchronized(ETableSync tableSync) {
        if (tableSyncs != null) {
            for (TableSync tables : tableSyncs) {
                if (tables.getTable().equalsIgnoreCase(tableSync.getName())) {
                    return tables.isSync();
                }
            }
        }
        return false;
    }

    public interface OnDownloadFinish {
        void onDone();
    }

}
