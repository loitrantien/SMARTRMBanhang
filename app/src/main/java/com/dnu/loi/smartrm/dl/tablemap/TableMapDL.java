package com.dnu.loi.smartrm.dl.tablemap;

import com.dnu.loi.smartrm.obj.Floor;
import com.dnu.loi.smartrm.obj.Table;

import java.util.ArrayList;
import java.util.List;

/**
 * Mô tả:
 * <p>
 * Created by loi on 18/04/2018.
 */

public class TableMapDL implements ITableMapDL {
    @Override
    public List<Table> getAllTable() {
        List<Table> tables = new ArrayList<>();

        for (int i = 1; i <= 12; i++) {

            Table table1 = new Table();
            table1.setTableId("axcc");
            table1.setTableNum(i);

            if (i % 2 == 0) {
                table1.setSelected(true);
                table1.setTableType(Integer.parseInt("2" + i));
            } else {
                table1.setTableType(Integer.parseInt("2" + (i + 1)));
            }
            tables.add(table1);
        }
        for (int i = 1; i <= 12; i++) {

            Table table1 = new Table();
            table1.setTableId("axcc");
            table1.setTableNum(i);

            if (i % 2 == 0) {
                table1.setTableType(Integer.parseInt("1" + i));
            } else {
                table1.setSelected(true);
                table1.setTableType(Integer.parseInt("1" + (i + 1)));
            }
            tables.add(table1);
        }
        return tables;
    }

    @Override
    public List<Floor> getAllFloor() {
        return null;
    }

    @Override
    public List<Table> getTableByFloorID(String floorID) {
        return null;
    }
}
