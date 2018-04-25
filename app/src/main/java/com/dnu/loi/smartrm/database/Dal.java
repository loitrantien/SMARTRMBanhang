package com.dnu.loi.smartrm.database;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;


import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import static com.dnu.loi.smartrm.common.ConstHelper.ERROR_VALUE;

public class Dal implements IDAL {
    private MySQLiteDatabase databaseHelper;
    private SQLiteDatabase mSqLiteDatabase;
    private static IDAL REPOSITORY;

    private Dal(MySQLiteDatabase sqLiteDatabase) {
        this.databaseHelper = sqLiteDatabase;
        try {
            open(true);
        } catch (DalException e) {
            e.printStackTrace();
        }
    }

    public static void newInstance(Context context) {
        if (REPOSITORY == null) {
            REPOSITORY = new Dal(MySQLiteDatabase.getInstance(context));
        }
    }

    public static IDAL getInstance() {
        return REPOSITORY;
    }

    @Override
    public void close()
            throws DalException {
        if (this.databaseHelper == null) {
            throw new DalException("không thể đóng database vì sqLiteDatabaseHelper = null");
        }
        this.mSqLiteDatabase.close();
    }

    @Override
    public void open(Boolean hasWrite)
            throws DalException {
        if (this.databaseHelper == null) {
            throw new DalException("không thể mở database vì sqLiteDatabaseHelper = null");
        }
        if (hasWrite) {
            this.mSqLiteDatabase = this.databaseHelper.getWritableDatabase();
            return;
        }
        this.mSqLiteDatabase = this.databaseHelper.getReadableDatabase();
    }

    private Object getIntFromCursor(Cursor cursor, DatabaseColumn column) {
        int index = cursor.getColumnIndex(column.columnName());
        if (index != ERROR_VALUE) {
            return cursor.getInt(index);
        }
        return null;
    }

    private Object getDoubleFromCursor(Cursor cursor, DatabaseColumn column) {
        int index = cursor.getColumnIndex(column.columnName());
        if (index != ERROR_VALUE) {
            return cursor.getDouble(index);
        }
        return null;
    }

    private Object getLongFromCursor(Cursor cursor, DatabaseColumn column) {
        int index = cursor.getColumnIndex(column.columnName());
        if (index != ERROR_VALUE) {
            return cursor.getLong(index);
        }
        return null;
    }

    private Object getFloatFromCursor(Cursor cursor, DatabaseColumn column) {
        int index = cursor.getColumnIndex(column.columnName());
        if (index != ERROR_VALUE) {
            return cursor.getFloat(index);
        }
        return null;
    }

    private Object getStringFromCursor(Cursor cursor, DatabaseColumn column) {
        int index = cursor.getColumnIndex(column.columnName());
        if (index != ERROR_VALUE) {
            return cursor.getString(index);
        }
        return null;
    }

    private Object getDataFromCursor(Field field, Cursor cursor, DatabaseColumn column) {
        if (column != null && field != null && cursor != null) {
            if (field.getType().isAssignableFrom(Integer.class) || field.getType().isAssignableFrom(int.class)) {
                return getIntFromCursor(cursor, column);
            }
            if (field.getType().isAssignableFrom(String.class)) {
                return getStringFromCursor(cursor, column);
            }
            if (field.getType().isAssignableFrom(Double.class) || field.getType().isAssignableFrom(double.class)) {
                return getDoubleFromCursor(cursor, column);
            }
            if (field.getType().isAssignableFrom(Long.class) || field.getType().isAssignableFrom(long.class)) {
                return getLongFromCursor(cursor, column);
            }
            if (field.getType().isAssignableFrom(Float.class) || field.getType().isAssignableFrom(float.class)) {
                return getFloatFromCursor(cursor, column);
            }
            if (field.getType().isAssignableFrom(Boolean.class) || field.getType().isAssignableFrom(boolean.class)) {
                Object o = getIntFromCursor(cursor, column);
                return o != null && o.toString().equals("1");
            }
        }
        return null;
    }

    public <DbObject> List<DbObject> getAll(Class<DbObject> mClass) throws DalException {
        if (mClass == null) {
            throw new DalException("không thể lấy các bản ghi từ database vì mClass = null");
        }
        List<DbObject> dbObjectList = new ArrayList<>();
        DatabaseTable databaseTable = mClass.getAnnotation(DatabaseTable.class);
        String query;

        if (databaseTable != null) {
            query = String.format("SELECT  * FROM '%s'", (databaseTable).TableName());
        } else {
            query = String.format("SELECT  * FROM '%s'", mClass.getSimpleName());
        }

        Cursor cursor = this.mSqLiteDatabase.rawQuery(query, null);

        Field[] fields = mClass.getDeclaredFields();

        if (cursor != null) {
            cursor.moveToFirst();
            do {
                try {
                    DbObject dbObject = mClass.newInstance();

                    for (Field field : fields) {
                        field.setAccessible(true);
                        DatabaseColumn column = field.getAnnotation(DatabaseColumn.class);
                        if (column != null) {
                            field.set(dbObject, getDataFromCursor(field, cursor, column));
                        }
                    }
                    dbObjectList.add(dbObject);

                } catch (Exception e) {
                    //todo
                }


            } while (cursor.moveToNext());
            cursor.close();
        }
        return dbObjectList;

    }

    public <DbObject> List<DbObject> getAll(ICustomColumnData customColumnData, Class<DbObject> mClass) throws DalException {
        if (mClass == null) {
            throw new DalException("không thể lấy các bản ghi từ database vì mClass = null");
        }
        List<DbObject> dbObjectList = new ArrayList<>();
        DatabaseTable databaseTable = mClass.getAnnotation(DatabaseTable.class);
        String query;

        if (databaseTable != null) {
            query = String.format("SELECT  * FROM '%s'", (databaseTable).TableName());
        } else {
            query = String.format("SELECT  * FROM '%s'", mClass.getSimpleName());
        }
        Cursor cursor = this.mSqLiteDatabase.rawQuery(query, null);

        Field[] fields = mClass.getDeclaredFields();

        if (cursor != null) {
            cursor.moveToFirst();
            do {
                try {
                    DbObject dbObject = mClass.newInstance();

                    for (Field field : fields) {
                        field.setAccessible(true);
                        DatabaseColumn column = field.getAnnotation(DatabaseColumn.class);
                        if (column != null) {
                            if (column.isEnableCustom()) {
                                field.set(dbObject, customColumnData.doCustom(
                                        getStringFromCursor(cursor, column),
                                        column.classCustom() != Object.class ? column.classCustom() : field.getType())
                                );
                                open(false);
                            } else
                                field.set(dbObject, getDataFromCursor(field, cursor, column));
                        }
                    }
                    dbObjectList.add(dbObject);

                } catch (Exception e) {
                    Log.e("getAll", e.getMessage());
                }


            } while (cursor.moveToNext());
            cursor.close();
        }
        return dbObjectList;
    }

    public <DbObject> List<DbObject> query(String query, Class<DbObject> mClass) throws DalException {
        if (mClass == null) {
            throw new DalException("không thể lấy các bản ghi từ database vì mClass = null");
        }
        List<DbObject> dbObjectList = new ArrayList<>();

        Cursor cursor = this.mSqLiteDatabase.rawQuery(query, null);

        Field[] fields = mClass.getDeclaredFields();

        if (cursor != null) {
            cursor.moveToFirst();
            do {
                try {
                    DbObject dbObject = mClass.newInstance();

                    for (Field field : fields) {
                        field.setAccessible(true);
                        DatabaseColumn column = field.getAnnotation(DatabaseColumn.class);
                        if (column != null)
                            field.set(dbObject, getDataFromCursor(field, cursor, column));
                    }
                    dbObjectList.add(dbObject);

                } catch (Exception e) {
                    //todo
                }


            } while (cursor.moveToNext());
            cursor.close();
        }
        return dbObjectList;
    }

    public <DbObject> List<DbObject> query(String query, ICustomColumnData customColumnData, Class<DbObject> mClass) throws DalException {
        if (mClass == null) {
            throw new DalException("không thể lấy các bản ghi từ database vì mClass = null");
        }
        List<DbObject> dbObjectList = new ArrayList<>();

        Cursor cursor = this.mSqLiteDatabase.rawQuery(query, null);

        Field[] fields = mClass.getDeclaredFields();

        if (cursor != null) {
            cursor.moveToFirst();
            do {
                try {
                    DbObject dbObject = mClass.newInstance();

                    for (Field field : fields) {
                        field.setAccessible(true);
                        DatabaseColumn column = field.getAnnotation(DatabaseColumn.class);
                        if (column != null) {
                            if (column.isEnableCustom()) {
                                field.set(dbObject, customColumnData.doCustom(
                                        getStringFromCursor(cursor, column),
                                        column.classCustom() != Object.class ? column.classCustom() : field.getType())
                                );
                                open(false);
                            } else
                                field.set(dbObject, getDataFromCursor(field, cursor, column));

                        }
                    }
                    dbObjectList.add(dbObject);

                } catch (Exception e) {
                    //todo
                }


            } while (cursor.moveToNext());
            cursor.close();
        }
        return dbObjectList;
    }

    @Override
    public <DbObject> long save(DbObject paramDbObject, Class<DbObject> mClass) throws DalException {

        DatabaseTable databaseTable = mClass.getAnnotation(DatabaseTable.class);

        ContentValues contentValue = new ContentValues();

        Field[] fields = mClass.getDeclaredFields();

        if (fields != null) {
            for (Field field : fields) {
                try {
                    field.setAccessible(true);
                    DatabaseColumn column = field.getAnnotation(DatabaseColumn.class);

                    if (column != null) {
                        if (column.hasAutoIncrement()) {
                            continue;
                        }
                        if (column.isEnableCustom())
                            continue;
                        contentValue.put(column.columnName(), field.get(paramDbObject).toString());
                    }
                } catch (Exception e) {
                    //todo
                }

            }
        }

        long result;
        if (databaseTable != null) {
            result = contentValue.size() == 0 ? -1 : mSqLiteDatabase.insert("'" + databaseTable.TableName() + "'", null, contentValue);
        } else {
            result = contentValue.size() == 0 ? -1 : mSqLiteDatabase.insert("'" + mClass.getSimpleName() + "'", null, contentValue);
        }

        return result;
    }

    @Override
    public <DbObject> int update(DbObject paramDbObject, Class<DbObject> mClass) throws DalException {

        DatabaseTable databaseTable = mClass.getAnnotation(DatabaseTable.class);

        ContentValues contentValue = new ContentValues();

        Field[] fields = mClass.getDeclaredFields();

        String whereClause = "";
        List<String> whereArgs = new ArrayList<>();

        if (fields != null) {
            for (Field field : fields) {
                try {
                    field.setAccessible(true);
                    DatabaseColumn column = field.getAnnotation(DatabaseColumn.class);

                    if (column != null) {
                        if (column.isPrimaryKey()) {
                            whereClause = whereClause.isEmpty()
                                    ? column.columnName() + " = ?"
                                    : whereClause + " AND " + column.columnName() + " = ?";
                            whereArgs.add(field.get(paramDbObject).toString());

                        }

                        if (column.isEnableCustom())
                            continue;

                        contentValue.put(column.columnName(), field.get(paramDbObject).toString());
                    }
                } catch (Exception e) {
                    //todo
                }

            }
        }

        String[] whereArgsArray = new String[whereArgs.size()];

        for (int i = 0; i < whereArgs.size(); i++) {
            whereArgsArray[i] = whereArgs.get(i);
        }

        int result;

        if (databaseTable != null) {
            result = contentValue.size() == 0 ? -1 : mSqLiteDatabase.update("'" + databaseTable.TableName() + "'", contentValue, whereClause, whereArgsArray);

        } else {
            result = contentValue.size() == 0 ? -1 : mSqLiteDatabase.update(mClass.getSimpleName(), contentValue, whereClause, whereArgsArray);
        }
        return result;
    }

    @Override
    public <DbObject> int delete(DbObject paramDbObject, Class<DbObject> mClass) throws DalException {

        DatabaseTable databaseTable = mClass.getAnnotation(DatabaseTable.class);

        Field[] fields = mClass.getDeclaredFields();

        String whereClause = "";
        List<String> whereArgs = new ArrayList<>();

        if (fields != null) {
            for (Field field : fields) {
                try {
                    field.setAccessible(true);
                    DatabaseColumn column = field.getAnnotation(DatabaseColumn.class);

                    if (column != null) {
                        if (column.isPrimaryKey()) {
                            whereClause = whereClause.isEmpty()
                                    ? column.columnName() + " = ?"
                                    : whereClause + " AND " + column.columnName() + " = ?";
                            whereArgs.add(field.get(paramDbObject).toString());
                        }
                    }
                } catch (Exception e) {
                    //todo
                }

            }
        }

        String[] whereArgsArray = new String[whereArgs.size()];

        for (int i = 0; i < whereArgs.size(); i++) {
            whereArgsArray[i] = whereArgs.get(i);
        }

        int result;
        if (databaseTable != null) {
            result = mSqLiteDatabase.delete("'" + databaseTable.TableName() + "'", whereClause, whereArgsArray);
        } else {
            result = mSqLiteDatabase.delete(mClass.getSimpleName(), whereClause, whereArgsArray);
        }

        return result;
    }

    public interface ICustomColumnData {
        Object doCustom(Object data, Class mClass) throws DalException;
    }
}