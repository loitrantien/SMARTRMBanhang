package com.dnu.loi.smartrm.common;

/**
 * Mô tả:
 * <p>
 * Created by loi on 03/05/2018.
 */

public enum OrderState {
    NEW("NEW"), DONE("DONE"), CHECKED("CHECKED"), IMPLEMENTED("IMPLEMENTED");

    private String state;

    OrderState(String state) {
        this.state = state;
    }

    public static OrderState getState(String s){
        switch (s){
            case "NEW":
                return NEW;
            case "DONE":
                return DONE;
            case "CHECKED":
                return CHECKED;
            case "IMPLEMENTED":
                return IMPLEMENTED;
        }

        return null;
    }

    public String getState() {
        return state;
    }
}
