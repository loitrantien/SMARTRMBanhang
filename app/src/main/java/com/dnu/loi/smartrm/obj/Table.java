package com.dnu.loi.smartrm.obj;

import com.dnu.loi.smartrm.database.DatabaseColumn;
import com.dnu.loi.smartrm.database.DatabaseTable;
import com.dnu.loi.smartrm.utils.TableType;

/**
 * Mô tả: class mô tả bàn
 * <p>
 * Created by loi on 07/04/2018.
 */
@DatabaseTable(TableName = "TABLE")
public class Table {
    @DatabaseColumn(columnName = "TableId",isPrimaryKey = true)
    private String TableId;
    @DatabaseColumn(columnName = "FloorId",isPrimaryKey = true)
    private String FloorId;
    @DatabaseColumn(columnName = "TableNum")
    private int tableNum;

    @DatabaseColumn(columnName = "TableType")
    private int tableType;

    private boolean isSelected;

    private int peopleCount;

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        this.isSelected = selected;
    }

    public int getPeopleCount() {
        return peopleCount;
    }

    public void setPeopleCount(int peopleCount) {
        this.peopleCount = peopleCount;
    }

    public String getTableId() {
        return TableId;
    }

    public void setTableId(String tableId) {
        TableId = tableId;
    }

    public int getTableNum() {
        return tableNum;
    }

    public void setTableNum(int tableNum) {
        this.tableNum = tableNum;
    }

    public TableType getTableType() {
        switch (tableType){
            case 12:
                return TableType.CIRCLE_2;
            case 14:
                return TableType.CIRCLE_4;
            case 16:
                return TableType.CIRCLE_6;
            case 18:
                return TableType.CIRCLE_8;
            case 110:
                return TableType.CIRCLE_10;
            case 112:
                return TableType.CIRCLE_12;
            case 22:
                return TableType.SQUARE_2;
            case 24:
                return TableType.SQUARE_4;
            case 26:
                return TableType.SQUARE_6;
            case 28:
                return TableType.SQUARE_8;
            case 210:
                return TableType.SQUARE_10;
            case 212:
                return TableType.SQUARE_12;
            default:
                return TableType.SQUARE_6;
        }
    }

    public void setTableType(int tableType) {
        this.tableType = tableType;
    }

    public int getTableImageResource() {

        switch (tableType){
            case 12:
                return TableType.CIRCLE_2.getImageResource();
            case 14:
                return TableType.CIRCLE_4.getImageResource();
            case 16:
                return TableType.CIRCLE_6.getImageResource();
            case 18:
                return TableType.CIRCLE_8.getImageResource();
            case 110:
                return TableType.CIRCLE_10.getImageResource();
            case 112:
                return TableType.CIRCLE_12.getImageResource();
            case 22:
                return TableType.SQUARE_2.getImageResource();
            case 24:
                return TableType.SQUARE_4.getImageResource();
            case 26:
                return TableType.SQUARE_6.getImageResource();
            case 28:
                return TableType.SQUARE_8.getImageResource();
            case 210:
                return TableType.SQUARE_10.getImageResource();
            case 212:
                return TableType.SQUARE_12.getImageResource();
            default:
                return TableType.SQUARE_6.getImageResource();
        }
    }
}
