package com.shijia.web.repository.dao.impl.mybatis;

import com.shijia.web.common.framework.HttpContext;
import com.shijia.web.repository.dao.BaseDataPersistenceObject;
import com.shijia.web.repository.dao.DaoMapper;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import java.lang.reflect.Field;
import java.util.Map;


/**
 * Created by Tangxinqi on 2016/6/18.
 */
public class DataPersistenceMySqlObjectImpl extends BaseDataPersistenceObject {

    private SqlSessionFactory sqlSessionFactory;

    private DaoMapper wapper;


    public DataPersistenceMySqlObjectImpl() {
        WebApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(HttpContext.getRequest().getServletContext());
        this.sqlSessionFactory = (SqlSessionFactory) context.getBean("sqlSessionFactory");
        this.wapper = this.sqlSessionFactory.openSession().getMapper(DaoMapper.class);
    }

    public void close() {

    }

    public void commit() {

    }

    /**
     * 通过传入ID来查询
     * @param id
     * @param tableName
     * @param clazz
     * @return
     */

    public Object selectById(String id,String tableName, Class<?> clazz) {

        Map<String, Object> map = wapper.selectOneById(id,tableName);
        Object resultBean = this.formatMapToBean(map, clazz);
        return resultBean;
    }


    /**
     * 通过where查询条件进行查询 sqlwhere形如 1=1；
     * @param sqlWhere
     * @param tableName
     * @param clazz
     * @return
     */
    public Object selectBySqlFilter(String sqlWhere, String tableName, Class<?> clazz) {

        Map<String,Object> map = wapper.selectOneByFilter(sqlWhere,tableName);
        Object resultBean  = this.formatMapToBean(map,clazz);
        return resultBean;
    }



    private <T> T formatMapToBean(Map<String,Object> map, Class<T> clazz){

        T object = null;

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
}
