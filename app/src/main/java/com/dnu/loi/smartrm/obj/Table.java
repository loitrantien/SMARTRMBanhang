package com.dnu.loi.smartrm.obj;

import com.dnu.loi.smartrm.database.DatabaseColumn;
import com.dnu.loi.smartrm.database.DatabaseTable;
import com.dnu.loi.smartrm.common.TableType;

/**
 * Mô tả: class mô tả bàn
 * <p>
 * Created by loi on 07/04/2018.
 */
@DatabaseTable(TableName = "table")
public class Table {
    @DatabaseColumn(columnName = "id",isPrimaryKey = true)
    private int TableId;

    @DatabaseColumn(columnName = "id_floor",isPrimaryKey = true)
    private String FloorId;

    @DatabaseColumn(columnName = "name")
    private String tableNum;

    @DatabaseColumn(columnName = "type")
    private String  tableType;

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

    public int getTableId() {
        return TableId;
    }

    public void setTableId(int tableId) {
        TableId = tableId;
    }

    public String getTableNum() {
        return tableNum;
    }

    public void setTableNum(String tableNum) {
        this.tableNum = tableNum;
    }

    public TableType getTableType() {
        switch (tableType){
            case "CIRCLE_2":
                return TableType.CIRCLE_2;
            case "CIRCLE_4":
                return TableType.CIRCLE_4;
            case "CIRCLE_6":
                return TableType.CIRCLE_6;
            case "CIRCLE_8":
                return TableType.CIRCLE_8;
            case "CIRCLE_10":
                return TableType.CIRCLE_10;
            case "CIRCLE_12":
                return TableType.CIRCLE_12;
            case "SQUARE_2":
                return TableType.SQUARE_2;
            case "SQUARE_4":
                return TableType.SQUARE_4;
            case "SQUARE_6":
                return TableType.SQUARE_6;
            case "SQUARE_8":
                return TableType.SQUARE_8;
            case "SQUARE_10":
                return TableType.SQUARE_10;
            case "SQUARE_12":
                return TableType.SQUARE_12;
            default:
                return TableType.SQUARE_6;
        }
    }

    public void setTableType(String tableType) {
        this.tableType = tableType;
    }

    public int getTableImageResource() {

        switch (tableType){
            case "CIRCLE_2":
                return TableType.CIRCLE_2.getImageResource();
            case "CIRCLE_4":
                return TableType.CIRCLE_4.getImageResource();
            case "CIRCLE_6":
                return TableType.CIRCLE_6.getImageResource();
            case "CIRCLE_8":
                return TableType.CIRCLE_8.getImageResource();
            case "CIRCLE_10":
                return TableType.CIRCLE_10.getImageResource();
            case "CIRCLE_12":
                return TableType.CIRCLE_12.getImageResource();
            case "SQUARE_2":
                return TableType.SQUARE_2.getImageResource();
            case "SQUARE_4":
                return TableType.SQUARE_4.getImageResource();
            case "SQUARE_6":
                return TableType.SQUARE_6.getImageResource();
            case "SQUARE_8":
                return TableType.SQUARE_8.getImageResource();
            case "SQUARE_10":
                return TableType.SQUARE_10.getImageResource();
            case "SQUARE_12":
                return TableType.SQUARE_12.getImageResource();
            default:
                return TableType.SQUARE_6.getImageResource();
        }
    }
}
