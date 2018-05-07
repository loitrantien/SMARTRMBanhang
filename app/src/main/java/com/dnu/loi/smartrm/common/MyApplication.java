package com.dnu.loi.smartrm.common;

import android.app.Application;
import com.dnu.loi.smartrm.pref.ApplicationCache;
import com.dnu.loi.smartrm.utils.DataBaseHelper;

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
        DataBaseHelper.copyAssetToDatabase();
        if (!ApplicationCache.getInstance().contains(ConstHelper.TABLES_SYNC)) {
            ApplicationCache.getInstance().putString(ConstHelper.TABLES_SYNC, ConstHelper.TABLES_SYNC_DATA);
        }
    }
}
