package com.shijia.web.repository.mapper;

import com.shijia.web.repository.mapper.domain.CustomPageDO;
import com.shijia.web.repository.mapper.domain.CustomPageTypeDO;

import java.util.List;
import java.util.Map;

/**
 * @author YanxiSir
 * @since 16/12/22
 */
public interface CustomPageDAO {

    /**
     * 获取所有种类自定义页面
     *
     * @return
     */
    List<CustomPageTypeDO> selectAllCustomType();


    int insertNewCustomPage(CustomPageDO pageDO);

    int updateCustomPageById(CustomPageDO pageDO);

    /**
     * 查询某个页面的所有版本
     *
     * @param pageNo
     * @return
     */
    List<CustomPageDO> selectAllVersionByPageNo(String pageNo);

    /**
     * 通过id获取页面详情
     *
     * @param id
     * @return
     */
    CustomPageDO selectCustomPageById(int id);

    /**
     * 查找正在使用的页面
     *
     * @param pageNo
     * @return
     */
    CustomPageDO selectUsingPageByPageNo(String pageNo);
}
