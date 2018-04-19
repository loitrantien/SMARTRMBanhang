package com.dnu.loi.smartrm.common;

import android.app.Application;
import android.content.Context;

import com.dnu.loi.smartrm.database.Dal;

/**
 * Mô tả: custom file application
 * <p>
 * Created by loi on 16/04/2018.
 */

public class MyApplication extends Application {
    private static MyApplication instance;

    public static MyApplication getInstance() {
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        Dal.newInstance(getApplicationContext());
    }

}
