package com.dnu.loi.smartrm.entity;

import com.dnu.loi.smartrm.database.DatabaseColumn;
import com.dnu.loi.smartrm.database.DatabaseTable;

/**
 * Mô tả:
 * <p>
 * Created by loi on 05/05/2018.
 */
@DatabaseTable(TableName = "tbl_sync")
public class TableSync {

    @DatabaseColumn(columnName = "table_name", isPrimaryKey = true)
    private String table;

    @DatabaseColumn(columnName = "is_sync")
    private boolean isSync;

    public TableSync() {
    }

    public TableSync(String table, boolean isSync) {
        this.table = table;
        this.isSync = isSync;
    }

    public String getTable() {
        return table;
    }

    public void setTable(String table) {
        this.table = table;
    }

    public boolean isSync() {
        return isSync;
    }

    public void setSync(boolean sync) {
        isSync = sync;
    }
}
