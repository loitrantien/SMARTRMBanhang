package com.dnu.loi.smartrm.bl.tablemap;

import com.dnu.loi.smartrm.dl.tablemap.ITableMapDL;
import com.dnu.loi.smartrm.entity.Floor;
import com.dnu.loi.smartrm.entity.Order;
import com.dnu.loi.smartrm.entity.Table;

import java.util.List;

/**
 * Mô tả:
 * <p>
 * Created by loi on 18/04/2018.
 */

public class TableMapBL implements ITableMapBL {

    private ITableMapDL dl;

    public TableMapBL(ITableMapDL dl) {
        this.dl = dl;
    }

    @Override
    public void getTablesSelected(onDataLoaded<List<Table>> listener) {
        new Thread(() -> {
            try {
                List<Table> tables = dl.getTablesSelected();

                if (tables == null)
                    listener.onFailed();
                else
                    listener.onResponse(tables);

            } catch (Exception e) {
                e.printStackTrace();
                listener.onException(e);
            }
        }).start();
    }

    @Override
    public void loadAllFloor(onDataLoaded<List<Floor>> listener) {
        new Thread(() -> {
            try {
                List<Floor> floors = dl.getAllFloor();

                if (floors == null)
                    listener.onFailed();
                else
                    listener.onResponse(floors);

            } catch (Exception e) {
                e.printStackTrace();
                listener.onException(e);
            }
        }).start();
    }

    @Override
    public void loadTablesByFloor(Floor floor, onDataLoaded<List<Table>> listener) {
        new Thread(() -> {
            try {
                List<Table> tables = dl.getTablesByFloorID(floor);

                if (tables == null)
                    listener.onFailed();
                else
                    listener.onResponse(tables);

            } catch (Exception e) {
                e.printStackTrace();
                listener.onException(e);
            }
        }).start();
    }

    @Override
    public void getOrderFromTable(Table table,onDataLoaded<Order> listener) {
        new Thread(() -> {
            try {
                Order order = dl.getOrderFromTable(table);

                if (order == null)
                    listener.onFailed();
                else
                    listener.onResponse(order);

            } catch (Exception e) {
                e.printStackTrace();
                listener.onException(e);
            }
        }).start();
    }


}
