package com.dnu.loi.smartrm.database;

import java.util.List;

public interface IDAL {

    public void close()
            throws DalException;

    public void open(Boolean hasWrite)
            throws DalException;

    <DbObject> int delete(DbObject paramDbObject, Class<DbObject> mClass)
            throws DalException;

    <DbObject> List<DbObject> getAll(Class<DbObject> mClass)
            throws DalException;

    <DbObject> List<DbObject> getAll(Dal.ICustomColumnData paramICustomColumnData, Class<DbObject> mClass)
            throws DalException;

    <DbObject> DbObject firstOrDefault(String paramString, Class<DbObject> mClass)
            throws DalException;
    <DbObject> DbObject firstOrDefault(String paramString, Dal.ICustomColumnData paramICustomColumnData, Class<DbObject> mClass)
            throws DalException;

    <DbObject> List<DbObject> query(String paramString, Class<DbObject> mClass)
            throws DalException;

    <DbObject> List<DbObject> query(String paramString, Dal.ICustomColumnData paramICustomColumnData, Class<DbObject> mClass)
            throws DalException;

    <DbObject> long save(DbObject paramDbObject, Class<DbObject> mClass)
            throws DalException;
    <DbObject> long saveWithOnConflict(DbObject paramDbObject, Class<DbObject> mClass) throws DalException;

    <DbObject> int update(DbObject paramDbObject, Class<DbObject> mClass)
            throws DalException;

    <DbObject> boolean contain(DbObject paramDbObject, Class<DbObject> mClass)
            throws DalException;
}
