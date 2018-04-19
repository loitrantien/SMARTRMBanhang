package com.dnu.loi.smartrm.database;

import java.util.List;

interface IDAL {
    <DbObject> int delete(DbObject paramDbObject, Class<DbObject> mClass)
            throws DalException;

    <DbObject> List<DbObject> getAll(Class<DbObject> mClass)
            throws DalException;

    <DbObject> List<DbObject> getAll(Dal.ICustomColumnData paramICustomColumnData, Class<DbObject> mClass)
            throws DalException;

    <DbObject> List<DbObject> query(String paramString, Class<DbObject> mClass)
            throws DalException;

    <DbObject> List<DbObject> query(String paramString, Dal.ICustomColumnData paramICustomColumnData, Class<DbObject> mClass)
            throws DalException;

    <DbObject> long save(DbObject paramDbObject, Class<DbObject> mClass)
            throws DalException;

    <DbObject> int update(DbObject paramDbObject, Class<DbObject> mClass)
            throws DalException;
}
