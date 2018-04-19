package com.dnu.loi.smartrm.pref;

import android.content.Context;
import android.content.SharedPreferences;

import com.dnu.loi.smartrm.common.ConstHelper;
import com.dnu.loi.smartrm.common.MyApplication;

/**
 * Mô tả:
 * <p>
 * Created by loi on 18/04/2018.
 */

public class ApplicationCache {
    private static ApplicationCache cache;
    private final String PREF_NAME = "SmartRM_Cached";
    private SharedPreferences.Editor editor = this._sharedPreferences.edit();
    private SharedPreferences _sharedPreferences = MyApplication.getInstance().getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);

    public static ApplicationCache getInstance() {
        if (cache == null) {
            cache = new ApplicationCache();
        }
        return cache;
    }

    public void clear(String key) {
        this.editor.remove(key);
        this.editor.commit();
    }

    public void clearAll() {
        this.editor.clear();
        this.editor.commit();
    }

    public boolean contains(String key) {
        return this._sharedPreferences.contains(key);
    }

    public boolean getBoolean(String key) {
        return this._sharedPreferences.getBoolean(key, false);
    }

    public boolean getBoolean(String key, boolean paramBoolean) {
        return this._sharedPreferences.getBoolean(key, paramBoolean);
    }

    public int getInt(String key) {
        return this._sharedPreferences.getInt(key, ConstHelper.ERROR_VALUE);
    }

    public int getInt(String key, int defValue) {
        return this._sharedPreferences.getInt(key, defValue);
    }

    public long getLong(String key) {
        return this._sharedPreferences.getLong(key, ConstHelper.ERROR_VALUE);
    }

    public String getString(String key) {
        return this._sharedPreferences.getString(key, null);
    }

    public String getString(String key, String defValue) {
        return this._sharedPreferences.getString(key, defValue);
    }

    public void putBoolean(String key, boolean value) {
        if (key == null) {
            return;
        }
        this.editor.putBoolean(key, value);
        this.editor.commit();
    }

    public void putBooleanSync(String key, boolean value) {
        if (key == null) {
            return;
        }
        this.editor.putBoolean(key, value);
        this.editor.apply();
    }

    public void putInt(String key, int value) {
        if (key == null) {
            return;
        }
        this.editor.putInt(key, value);
        this.editor.commit();
    }

    public void putLong(String key, long value) {
        if (key == null) {
            return;
        }
        this.editor.putLong(key, value);
        this.editor.commit();
    }

    public void putString(String key, String value) {
        if (key == null) {
            return;
        }
        if (value == null) {
            this.editor.remove(key);
        }
        this.editor.putString(key, value);
        this.editor.commit();
    }
}
