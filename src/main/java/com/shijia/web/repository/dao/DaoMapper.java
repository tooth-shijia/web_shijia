package com.shijia.web.repository.dao;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.Map;

/**
 * Created by Tangxinqi on 2016/6/19.
 */
public interface DaoMapper {

    @SelectProvider(type = SqlProvider.class, method = "getSelectOneSqlById")
    public Map<String,Object> selectOneById(@Param("ID") String ID,@Param("tableName") String tableName);
//    public Map<String,Object> selectOneById(String ID,String tableName);

    @SelectProvider(type = SqlProvider.class, method = "getSelectOneSqlByFilter")
    public Map<String,Object> selectOneByFilter(@Param("SqlWhere") String SqlWhere,@Param("tableName") String tableName);



}
