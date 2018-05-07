package com.dnu.loi.smartrm.ui.normal.tablemap;

import com.dnu.loi.smartrm.R;
import com.dnu.loi.smartrm.bl.tablemap.ITableMapBL;
import com.dnu.loi.smartrm.entity.Floor;
import com.dnu.loi.smartrm.entity.Order;
import com.dnu.loi.smartrm.entity.Table;
import com.dnu.loi.smartrm.ui.base.BasePresenter;
import com.dnu.loi.smartrm.ui.base.IBaseBL;
import com.dnu.loi.smartrm.utils.ExceptionHelper;
import com.dnu.loi.smartrm.utils.UIHelper;

import java.util.List;

/**
 * Mô tả:
 * <p>
 * Created by loi on 18/04/2018.
 */

public class TableMapPresenter extends BasePresenter<ITableMapView> implements ITableMapPresenter {

    private static final String LOAD_TABLE_BY_FLOOR_TAG = "TableMapPresenter#loadTablesByFloor";
    private static final String LOAD_ALL_FLOOR_TAG = "TableMapPresenter#loadAllFloor";
    private static final String LOAD_TABLE_SELECTED_TAG = "getTableMapSelected";
    private ITableMapBL bl;

    public TableMapPresenter(ITableMapBL bl) {
        this.bl = bl;
    }

    @Override
    public void onViewAttach(ITableMapView view) {
        mView = view;
    }

    @Override
    public void onViewDestroy() {
        mView = null;
        bl = null;
    }

    @Override
    public void initTableMap() {
        bl.loadAllFloor(new IBaseBL.onDataLoaded<List<Floor>>() {
            @Override
            public void onResponse(List<Floor> floors) {
                getView().setListFloor(floors);
                loadTablesByFloor(floors.get(0));
            }

            @Override
            public void onFailed() {
                getView().showError(UIHelper.getString(R.string.on_floor_load_error));
            }

            @Override
            public void onException(Exception e) {
                ExceptionHelper.handlerException(LOAD_ALL_FLOOR_TAG, e);
            }
        });
    }


    @Override
    public void loadTablesByFloor(Floor floor) {
        bl.loadTablesByFloor(floor, new IBaseBL.onDataLoaded<List<Table>>() {
            @Override
            public void onResponse(List<Table> tables) {
                getView().setListTable(tables);
                getTableMapSelected();
            }

            @Override
            public void onFailed() {
                getView().showError(UIHelper.getString(R.string.on_floor_load_error));
            }

            @Override
            public void onException(Exception e) {
                ExceptionHelper.handlerException(LOAD_TABLE_BY_FLOOR_TAG, e);
            }
        });
    }

    @Override
    public void getTableMapSelected() {
        bl.getTablesSelected(new IBaseBL.onDataLoaded<List<Table>>() {
            @Override
            public void onResponse(List<Table> tables) {
                getView().setTablesSelected(tables);
            }

            @Override
            public void onFailed() {
                getView().showError(UIHelper.getString(R.string.on_floor_load_error));
            }

            @Override
            public void onException(Exception e) {
                ExceptionHelper.handlerException(LOAD_TABLE_SELECTED_TAG, e);
            }
        });
    }

    @Override
    public void onTableSelectedClick(Table table) {

        bl.getOrderFromTable(table, new IBaseBL.onDataLoaded<Order>() {
            @Override
            public void onResponse(Order order) {
                mView.goToEditOrder(order);
            }

            @Override
            public void onFailed() {
                getView().showError(UIHelper.getString(R.string.on_floor_load_error));
            }

            @Override
            public void onException(Exception e) {
                ExceptionHelper.handlerException(LOAD_TABLE_SELECTED_TAG, e);
            }
        });
    }
}
