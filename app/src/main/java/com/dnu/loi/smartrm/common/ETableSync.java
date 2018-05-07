package com.dnu.loi.smartrm.common;

import com.dnu.loi.smartrm.entity.TableSync;

/**
 * Mô tả:
 * <p>
 * Created by loi on 05/05/2018.
 */

public enum ETableSync {
    DISHES("DISHES"),
    DISHES_TYPE("DISHES_TYPE"),
    TABLE("TABLE"),
    TABLE_TYPE("TABLE_TYPE"),
    FLOOR("FLOOR"),
    MENU("MENU"),
    ORDER("ORDER");
    private String name;

    ETableSync(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public TableSync getTableSync(boolean isSync) {
        return new TableSync(name, isSync);
    }

}
