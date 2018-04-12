package com.dnu.loi.smartrm.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class SQLiteDatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "mydb";
    private static SQLiteDatabaseHelper DATABASE_SINGLETON = null;

    private SQLiteDatabaseHelper(Context paramContext) {
        super(paramContext, "mydb", null, 1);
    }

    public static SQLiteDatabaseHelper getInstance(Context paramContext) {
        if (DATABASE_SINGLETON == null) {
            return new SQLiteDatabaseHelper(paramContext);
        }
        return DATABASE_SINGLETON;
    }

    public void onCreate(SQLiteDatabase paramSQLiteDatabase) {
    }

    public void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2) {
    }
}
