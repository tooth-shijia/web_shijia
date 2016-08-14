package com.shijia.web.repository.dao;


/**
 * Created by Tangxinqi on 2016/6/14.
 */
public interface DataPersistenceObject {

    public abstract void close();

    public abstract void commit();

    public abstract <T> T selectById(String id,String tableName, Class<T> clazz);

    public abstract <T> T selectBySqlFilter(String sqlWhere,String tableName, Class<T> clazz);

    public abstract <T> T selectBySql(String Sql,Class<T> clazz);
}
