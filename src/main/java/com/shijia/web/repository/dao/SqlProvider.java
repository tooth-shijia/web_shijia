package com.shijia.web.repository.dao;

import com.shijia.web.common.utils.LogHelper;

import java.util.Map;

/**
 * Created by Tangxinqi on 2016/6/19.
 */
public class SqlProvider {

    public String getSelectOneSqlById(Map<String, Object> para) {

        String Sql = "select * from  " + para.get("tableName") + " where id = #{ID}";
        LogHelper.info("Excute Sql："+Sql);
        return Sql;
    }

    public String getSelectOneSqlByFilter(Map<String, Object> para) {

        String Sql = "select * from " + para.get("tableName") + " where "+para.get("SqlWhere")+"";
        LogHelper.info("Excute Sql："+Sql);
        return Sql;
    }
}

