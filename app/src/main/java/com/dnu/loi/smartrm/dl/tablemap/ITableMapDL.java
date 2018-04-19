package com.dnu.loi.smartrm.dl.tablemap;

import com.dnu.loi.smartrm.obj.Floor;
import com.dnu.loi.smartrm.obj.Table;

import java.util.List;

/**
 * Mô tả:
 * <p>
 * Created by loi on 18/04/2018.
 */

public interface ITableMapDL {
    List<Table> getAllTable();

    List<Floor> getAllFloor();

    List<Table> getTableByFloorID(String floorID);
}
