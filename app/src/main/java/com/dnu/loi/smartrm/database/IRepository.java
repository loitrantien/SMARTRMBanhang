package com.dnu.loi.smartrm.database;

import java.util.List;

interface IRepository<T>
{
    int delete(T paramT)
            throws RepositoryException;

    List<T> getAll()
            throws RepositoryException;

    List<T> getAll(Repository.ICustomColumnData paramICustomColumnData)
            throws RepositoryException;

    List<T> query(String paramString)
            throws RepositoryException;

    List<T> query(String paramString, Repository.ICustomColumnData paramICustomColumnData)
            throws RepositoryException;

    long save(T paramT)
            throws RepositoryException;

    int update(T paramT)
            throws RepositoryException;
}
