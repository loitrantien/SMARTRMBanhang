package com.dnu.loi.smartrm.database;


import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class Repository<DbObject extends IMarkerSQLiteDatabase> implements IRepository<DbObject> {
    private SQLiteDatabaseHelper databaseHelper;
    private Class<DbObject> mClass;
    private SQLiteDatabase mSqLiteDatabase;

    Repository(Class<DbObject> paramClass, SQLiteDatabaseHelper paramSQLiteDatabaseHelper) {
        this.mClass = paramClass;
        this.databaseHelper = paramSQLiteDatabaseHelper;
    }

    private void close()
            throws RepositoryException {
        if (this.databaseHelper == null) {
            throw new RepositoryException("không thể đóng database vì sqLiteDatabaseHelper = null");
        }
        this.mSqLiteDatabase.close();
    }

    private void open(Boolean hasWrite)
            throws RepositoryException {
        if (this.databaseHelper == null) {
            throw new RepositoryException("không thể mở database vì sqLiteDatabaseHelper = null");
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

    public List<DbObject> getAll() throws RepositoryException {
        if (this.mClass == null) {
            throw new RepositoryException("không thể lấy các bản ghi từ database vì mClass = null");
        }
        List<DbObject> dbObjectList = new ArrayList<>();
        DatabaseTable databaseTable = this.mClass.getAnnotation(DatabaseTable.class);
        String query;

        if (databaseTable != null) {
            query = String.format("SELECT  * FROM %s", (databaseTable).TableName());
        } else {
            query = String.format("SELECT  * FROM %s", this.mClass.getSimpleName());
        }
        try {
            open(false);
        } catch (RepositoryException localRepositoryException) {
            //todo
        }
        Cursor cursor = this.mSqLiteDatabase.rawQuery(query, null);

        Field[] fields = mClass.getDeclaredFields();

        if (cursor != null) {
            cursor.moveToFirst();
            do {
                try {
                    DbObject dbObject = this.mClass.newInstance();

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

    public List<DbObject> getAll(ICustomColumnData customColumnData) throws RepositoryException {
        if (this.mClass == null) {
            throw new RepositoryException("không thể lấy các bản ghi từ database vì mClass = null");
        }
        List<DbObject> dbObjectList = new ArrayList<>();
        DatabaseTable databaseTable = this.mClass.getAnnotation(DatabaseTable.class);
        String query;

        if (databaseTable != null) {
            query = String.format("SELECT  * FROM %s", (databaseTable).TableName());
        } else {
            query = String.format("SELECT  * FROM %s", this.mClass.getSimpleName());
        }
        try {
            open(false);
        } catch (RepositoryException localRepositoryException) {
            //todo
        }
        Cursor cursor = this.mSqLiteDatabase.rawQuery(query, null);

        Field[] fields = mClass.getDeclaredFields();

        if (cursor != null) {
            cursor.moveToFirst();
            do {
                try {
                    DbObject dbObject = this.mClass.newInstance();

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

    public List<DbObject> query(String query) throws RepositoryException {
        if (this.mClass == null) {
            throw new RepositoryException("không thể lấy các bản ghi từ database vì mClass = null");
        }
        List<DbObject> dbObjectList = new ArrayList<>();

        try {
            open(false);
        } catch (RepositoryException localRepositoryException) {
            //todo
        }
        Cursor cursor = this.mSqLiteDatabase.rawQuery(query, null);

        Field[] fields = mClass.getDeclaredFields();

        if (cursor != null) {
            cursor.moveToFirst();
            do {
                try {
                    DbObject dbObject = this.mClass.newInstance();

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

    public List<DbObject> query(String query, ICustomColumnData customColumnData) throws RepositoryException {
        if (this.mClass == null) {
            throw new RepositoryException("không thể lấy các bản ghi từ database vì mClass = null");
        }
        List<DbObject> dbObjectList = new ArrayList<>();

        try {
            open(false);
        } catch (RepositoryException localRepositoryException) {
            //todo
        }
        Cursor cursor = this.mSqLiteDatabase.rawQuery(query, null);

        Field[] fields = mClass.getDeclaredFields();

        if (cursor != null) {
            cursor.moveToFirst();
            do {
                try {
                    DbObject dbObject = this.mClass.newInstance();

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
    public long save(DbObject paramDbObject) throws RepositoryException {

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
    public int update(DbObject paramDbObject) throws RepositoryException {

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
    public int delete(DbObject paramDbObject) throws RepositoryException {

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