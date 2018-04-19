package com.dnu.loi.smartrm.database;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class Dal implements IDAL {
    private SQLiteDatabaseHelper databaseHelper;
    private SQLiteDatabase mSqLiteDatabase;
    private static IDAL REPOSITORY;

    private Dal(SQLiteDatabaseHelper paramSQLiteDatabaseHelper) {
        this.databaseHelper = paramSQLiteDatabaseHelper;
    }

    public static IDAL newInstance(Context context) {
        if (REPOSITORY == null) {
            REPOSITORY = new Dal(SQLiteDatabaseHelper.getInstance(context));
        }
        return REPOSITORY;
    }

    public static IDAL getInstance() {
        return REPOSITORY;
    }


    private void close()
            throws DalException {
        if (this.databaseHelper == null) {
            throw new DalException("không thể đóng database vì sqLiteDatabaseHelper = null");
        }
        this.mSqLiteDatabase.close();
    }

    private void open(Boolean hasWrite)
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
        return cursor.getInt(cursor.getColumnIndex(column.columnName()));
    }

    private Object getStringFromCursor(Cursor cursor, DatabaseColumn column) {
        return cursor.getInt(cursor.getColumnIndex(column.columnName()));
    }

    public <DbObject> List<DbObject> getAll(Class<DbObject> mClass) throws DalException {
        if (mClass == null) {
            throw new DalException("không thể lấy các bản ghi từ database vì mClass = null");
        }
        List<DbObject> dbObjectList = new ArrayList<>();
        DatabaseTable databaseTable = mClass.getAnnotation(DatabaseTable.class);
        String query;

        if (databaseTable != null) {
            query = String.format("SELECT  * FROM %s", (databaseTable).TableName());
        } else {
            query = String.format("SELECT  * FROM %s", mClass.getSimpleName());
        }
        try {
            open(false);
        } catch (DalException localRepositoryException) {
            //todo
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
                            if (field.getType().isAssignableFrom(Integer.class)) {
                                field.set(dbObject, getIntFromCursor(cursor, column));
                            }
                            if (field.getType().isAssignableFrom(String.class)) {
                                field.set(dbObject, getStringFromCursor(cursor, column));
                            }
                        }
                    }
                    dbObjectList.add(dbObject);

                } catch (Exception e) {
                    //todo
                }


            } while (cursor.moveToNext());
            cursor.close();
            close();
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
            query = String.format("SELECT  * FROM %s", (databaseTable).TableName());
        } else {
            query = String.format("SELECT  * FROM %s", mClass.getSimpleName());
        }
        try {
            open(false);
        } catch (DalException localRepositoryException) {
            //todo
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
                            if (field.getType().isAssignableFrom(Integer.class)) {
                                field.set(dbObject, getIntFromCursor(cursor, column));
                            }
                            if (field.getType().isAssignableFrom(String.class)) {
                                field.set(dbObject, getStringFromCursor(cursor, column));
                            }
                            if (column.isEnableCustom()) {
                                field.set(dbObject, customColumnData.doCustom(
                                        getStringFromCursor(cursor, column),
                                        column.classCustom() != Object.class ? column.classCustom() : field.getType())
                                );
                            }

                        }
                    }
                    dbObjectList.add(dbObject);

                } catch (Exception e) {
                    //todo
                }


            } while (cursor.moveToNext());
            cursor.close();
            close();
        }
        return dbObjectList;
    }

    public <DbObject> List<DbObject> query(String query, Class<DbObject> mClass) throws DalException {
        if (mClass == null) {
            throw new DalException("không thể lấy các bản ghi từ database vì mClass = null");
        }
        List<DbObject> dbObjectList = new ArrayList<>();

        try {
            open(false);
        } catch (DalException localRepositoryException) {
            //todo
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
                            if (field.getType().isAssignableFrom(Integer.class)) {
                                field.set(dbObject, getIntFromCursor(cursor, column));
                            }
                            if (field.getType().isAssignableFrom(String.class)) {
                                field.set(dbObject, getStringFromCursor(cursor, column));
                            }
                        }
                    }
                    dbObjectList.add(dbObject);

                } catch (Exception e) {
                    //todo
                }


            } while (cursor.moveToNext());
            cursor.close();
            close();
        }
        return dbObjectList;
    }

    public <DbObject> List<DbObject> query(String query, ICustomColumnData customColumnData, Class<DbObject> mClass) throws DalException {
        if (mClass == null) {
            throw new DalException("không thể lấy các bản ghi từ database vì mClass = null");
        }
        List<DbObject> dbObjectList = new ArrayList<>();

        try {
            open(false);
        } catch (DalException localRepositoryException) {
            //todo
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
                            if (field.getType().isAssignableFrom(Integer.class)) {
                                field.set(dbObject, getIntFromCursor(cursor, column));
                            }
                            if (field.getType().isAssignableFrom(String.class)) {
                                field.set(dbObject, getStringFromCursor(cursor, column));
                            }
                            if (column.isEnableCustom()) {
                                field.set(dbObject, customColumnData.doCustom(
                                        getStringFromCursor(cursor, column),
                                        column.classCustom() != Object.class ? column.classCustom() : field.getType())
                                );
                            }

                        }
                    }
                    dbObjectList.add(dbObject);

                } catch (Exception e) {
                    //todo
                }


            } while (cursor.moveToNext());
            cursor.close();
            close();
        }
        return dbObjectList;
    }

    @Override
    public <DbObject> long save(DbObject paramDbObject, Class<DbObject> mClass) throws DalException {

        open(true);

        DatabaseTable databaseTable = mClass.getAnnotation(DatabaseTable.class);

        ContentValues contentValue = new ContentValues();

        Field[] fields = mClass.getDeclaredFields();

        if (fields != null) {
            for (Field field : fields) {
                try {

                    DatabaseColumn column = field.getAnnotation(DatabaseColumn.class);

                    if (column != null) {
                        if (column.hasAutoIncrement()) {
                            break;
                        }
                        contentValue.put(column.columnName(), field.get(paramDbObject).toString());
                    }
                } catch (Exception e) {
                    //todo
                }

            }
        }

        close();

        if (databaseTable != null) {
            return contentValue.size() == 0 ? -1 : mSqLiteDatabase.insert(databaseTable.TableName(), null, contentValue);
        } else {
            return contentValue.size() == 0 ? -1 : mSqLiteDatabase.insert(mClass.getSimpleName(), null, contentValue);
        }


    }

    @Override
    public <DbObject> int update(DbObject paramDbObject, Class<DbObject> mClass) throws DalException {

        open(true);

        DatabaseTable databaseTable = mClass.getAnnotation(DatabaseTable.class);

        ContentValues contentValue = new ContentValues();

        Field[] fields = mClass.getDeclaredFields();

        String whereClause = "";
        String whereArgs[] = new String[]{};

        if (fields != null) {
            for (Field field : fields) {
                try {

                    DatabaseColumn column = field.getAnnotation(DatabaseColumn.class);

                    if (column != null) {
                        if (column.isPrimaryKey()) {
                            whereClause = whereClause.isEmpty()
                                    ? column.columnName() + " = ?"
                                    : whereClause + " AND " + column.columnName() + " = ?";
                            if (whereArgs.length == 0) {
                                whereArgs[0] = field.get(paramDbObject).toString();
                            } else {
                                whereArgs[whereArgs.length] = field.get(paramDbObject).toString();
                            }
                        }

                        contentValue.put(column.columnName(), field.get(paramDbObject).toString());
                    }
                } catch (Exception e) {
                    //todo
                }

            }
        }

        close();

        if (databaseTable != null) {
            return contentValue.size() == 0 ? -1 : mSqLiteDatabase.update(databaseTable.TableName(), contentValue, whereClause, whereArgs);

        } else {
            return contentValue.size() == 0 ? -1 : mSqLiteDatabase.update(mClass.getSimpleName(), contentValue, whereClause, whereArgs);

        }
    }

    @Override
    public <DbObject> int delete(DbObject paramDbObject, Class<DbObject> mClass) throws DalException {

        open(true);

        DatabaseTable databaseTable = mClass.getAnnotation(DatabaseTable.class);

        Field[] fields = mClass.getDeclaredFields();

        String whereClause = "";
        String whereArgs[] = new String[]{};

        if (fields != null) {
            for (Field field : fields) {
                try {

                    DatabaseColumn column = field.getAnnotation(DatabaseColumn.class);

                    if (column != null) {
                        if (column.isPrimaryKey()) {
                            whereClause = whereClause.isEmpty()
                                    ? column.columnName() + " = ?"
                                    : whereClause + " AND " + column.columnName() + " = ?";
                            if (whereArgs.length == 0) {
                                whereArgs[0] = field.get(paramDbObject).toString();
                            } else {
                                whereArgs[whereArgs.length] = field.get(paramDbObject).toString();
                            }
                        }
                    }
                } catch (Exception e) {
                    //todo
                }

            }
        }

        close();

        if (databaseTable != null) {
            return mSqLiteDatabase.delete(databaseTable.TableName(), whereClause, whereArgs);

        } else {
            return mSqLiteDatabase.delete(mClass.getSimpleName(), whereClause, whereArgs);

        }
    }

    public interface ICustomColumnData<FiledType> {
        FiledType doCustom(Object data, Class mClass);
    }
}