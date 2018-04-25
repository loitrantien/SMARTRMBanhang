package com.dnu.loi.smartrm.dl.tablemap;

import com.dnu.loi.smartrm.common.ConstHelper;
import com.dnu.loi.smartrm.database.Dal;
import com.dnu.loi.smartrm.database.DalException;
import com.dnu.loi.smartrm.obj.Floor;
import com.dnu.loi.smartrm.obj.Table;

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
        return Dal.getInstance().getAll(Floor.class);
    }

    @Override
    public List<Table> getTablesByFloorID(Floor floor) throws DalException {
        if (floor.getId() == ConstHelper.GET_ALL_VALUE)
            return getAllTable();
        return Dal.getInstance().query("select * from 'table' WHERE id_floor = '" + floor.getId() + "'", Table.class);
    }

    @Override
    public List<Table> getTablesSelected() throws DalException {
        return Dal.getInstance().query("select id_table as id from 'order'",Table.class);
    }
}
