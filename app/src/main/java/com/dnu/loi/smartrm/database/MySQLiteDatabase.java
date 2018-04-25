package com.dnu.loi.smartrm.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import static com.dnu.loi.smartrm.common.CommonApp.DATABASE_NAME;

public class MySQLiteDatabase extends SQLiteOpenHelper {
    private static MySQLiteDatabase DATABASE_SINGLETON;

    private MySQLiteDatabase(Context paramContext) {
        super(paramContext, DATABASE_NAME, null, 1);
    }

    static MySQLiteDatabase getInstance(Context paramContext) {
        if (DATABASE_SINGLETON == null) {
            DATABASE_SINGLETON = new MySQLiteDatabase(paramContext);
        }
        return DATABASE_SINGLETON;
    }

    public void onCreate(SQLiteDatabase paramSQLiteDatabase) {
    }

    public void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2) {
    }
}
