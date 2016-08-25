package com.shijia.web.repository.dao.impl.mybatis;

import com.shijia.web.repository.dao.BaseDataPersistenceObject;
import com.shijia.web.repository.dao.DaoMapper;
import org.apache.ibatis.session.SqlSessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;
import java.lang.reflect.Field;
import java.util.Map;


/**
 * Created by Tangxinqi on 2016/6/18.
 */
@Component("mysqlDataSourse")
public class DataPersistenceMySqlObjectByMyBatisImpl extends BaseDataPersistenceObject implements InitializingBean {

    @Autowired
    private SqlSessionFactory sqlSessionFactory;

    private DaoMapper wapper;

    private Logger logger ;

    public DataPersistenceMySqlObjectByMyBatisImpl() {

        this.logger = LoggerFactory.getLogger(this.getClass());
    }


    public SqlSessionFactory getSqlSessionFactory() {
        return sqlSessionFactory;
    }

    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }




    public <T> T selectById(String id,String tableName, Class<T> clazz) {

        Map<String, Object> map = wapper.selectOneById(id,tableName);
        T resultBean = this.formatMapToBean(map, clazz);
        this.sqlSessionFactory.openSession().commit();
        return resultBean;
    }


    public <T> T selectBySqlFilter(String sqlWhere, String tableName, Class<T> clazz) {

        Map<String,Object> map = wapper.selectOneByFilter(sqlWhere,tableName);
        T resultBean  = this.formatMapToBean(map,clazz);
        return resultBean;
    }

    public <T> T selectBySql(String Sql, Class<T> clazz) {
        return null;
    }

    private <T> T formatMapToBean(Map<String,Object> map, Class<T> clazz){

        T object = null;
        if(map.isEmpty()){
            return null;
        }
        try {
            object = clazz.newInstance();
            Field[] fields = object.getClass().getDeclaredFields();
            for (Field field:fields){
                String fieldName = field.getName().toLowerCase();
                if(map.containsKey(fieldName)){
                    field.setAccessible(true);
                    field.set(object,map.get(fieldName));
                }
            }
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        return object;
    }

    public void close() {

    }

    public void commit() {

    }

    public void afterPropertiesSet() throws Exception {
        Assert.notNull(this.sqlSessionFactory,"sqlSessionFactory must init");
        this.wapper = this.sqlSessionFactory.openSession().getMapper(DaoMapper.class);
    }
}
