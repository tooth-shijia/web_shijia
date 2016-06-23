package com.shijia.web.repository.dao;


/**
 * Created by Tangxinqi on 2016/6/14.
 */
public interface DataPersistenceObject {
    public abstract void close();
    public abstract void commit();
    public abstract Object selectById(String id,String tableName, Class<?> clazz);
    public abstract Object selectBySqlFilter(String sqlWhere,String tableName, Class<?> clazz);
}
