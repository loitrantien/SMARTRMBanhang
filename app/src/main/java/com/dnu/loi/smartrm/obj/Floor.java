package com.dnu.loi.smartrm.obj;

import com.dnu.loi.smartrm.database.DatabaseColumn;
import com.dnu.loi.smartrm.database.DatabaseTable;

/**
 * Mô tả:
 * <p>
 * Created by loi on 18/04/2018.
 */
@DatabaseTable(TableName = "floor")
public class Floor {

    @DatabaseColumn(columnName = "id", isPrimaryKey = true)
    private int id;
    @DatabaseColumn(columnName = "name")
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
