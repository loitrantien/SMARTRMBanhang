package com.dnu.loi.smartrm.utils;

import android.os.Bundle;

import com.google.gson.Gson;

/**
 * Mô tả:
 * <p>
 * Created by loi on 18/04/2018.
 */

public class GsonHelper {
    private static Gson INSTANCE;

    public static Gson getInstance() {
        if (INSTANCE != null) {
            INSTANCE = new Gson();
        }
        return INSTANCE;
    }
}
