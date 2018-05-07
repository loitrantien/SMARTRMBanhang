package com.dnu.loi.smartrm.dl.tablemap;

import com.dnu.loi.smartrm.database.DalException;
import com.dnu.loi.smartrm.entity.Floor;
import com.dnu.loi.smartrm.entity.Order;
import com.dnu.loi.smartrm.entity.Table;

import java.util.List;

/**
 * Mô tả:
 * <p>
 * Created by loi on 18/04/2018.
 */

public interface ITableMapDL {
    List<Table> getAllTable() throws DalException;

    List<Floor> getAllFloor() throws DalException;

    List<Table> getTablesByFloorID(Floor floor) throws DalException;

    List<Table> getTablesSelected() throws  DalException;

    Order getOrderFromTable(Table table) throws DalException;
}
