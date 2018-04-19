package com.dnu.loi.smartrm.common;

/**
 * Mô tả:
 * <p>
 * Created by loi on 18/04/2018.
 */

public enum OrderMode {

    EDIT_MODE(0), ADD_MODE(1);

    private int mode;

    OrderMode(int mode) {
        this.mode = mode;
    }

    public static OrderMode getMode(int mode) {
        switch (mode) {
            case 0:
                return EDIT_MODE;
            case 1:
                return ADD_MODE;
            default:
                return null;
        }
    }

    public int getValues() {
        return mode;
    }
}
