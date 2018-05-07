package com.dnu.loi.smartrm.dl.tablemap;

import com.dnu.loi.smartrm.common.ConstHelper;
import com.dnu.loi.smartrm.database.Dal;
import com.dnu.loi.smartrm.database.DalException;
import com.dnu.loi.smartrm.entity.Floor;
import com.dnu.loi.smartrm.entity.Order;
import com.dnu.loi.smartrm.entity.OrderDetail;
import com.dnu.loi.smartrm.entity.Table;
import com.dnu.loi.smartrm.entity.TableType;

import java.util.List;

/**
 * Mô tả:
 * <p>
 * Created by loi on 18/04/2018.
 */

public class TableMapDL implements ITableMapDL {
    @Override
    public List<Table> getAllTable() throws DalException {
        return Dal.getInstance().getAll(Table.class);
    }

    @Override
    public List<Floor> getAllFloor() throws DalException {
        return Dal.getInstance().query("select * from tbl_floor order by code asc", Floor.class);
    }

    @Override
    public List<Table> getTablesByFloorID(Floor floor) throws DalException {
        if (floor.getId().equalsIgnoreCase(ConstHelper.GET_ALL_VALUE))
            return getAllTable();
        return Dal.getInstance().query("select * from 'tbl_table' WHERE floor_id = '" + floor.getId() + "'", (data, mClass) -> {
            if (mClass == TableType.class) {
                return Dal.getInstance().query("select * from 'tbl_tableType' WHERE id = '" + data + "'", TableType.class).get(0);
            }
            return null;
        }, Table.class);
    }

    @Override
    public List<Table> getTablesSelected() throws DalException {
        return Dal.getInstance().query("select table_id as id from 'tbl_order'", Table.class);
    }

    @Override
    public Order getOrderFromTable(Table table) throws DalException {
        Order order = Dal.getInstance().firstOrDefault("select * from 'tbl_order' where table_id = '" + table.getId() + "'",(data, mClass) -> {

            if (mClass == OrderDetail.class) {
                return Dal.getInstance().query(
                        "select * from 'tbl_orderDetail' where order_id ='" + data.toString() + "'",
                        OrderDetail.class);
            }

            return null;

        }, Order.class);
        order.setTable(table);
        return order;
    }
}
