package com.shijia.web.service;

import com.shijia.web.common.consts.enums.CustomPageStatusEnum;
import com.shijia.web.controller.admin.domain.custompage.AddOrUpCustomPageReq;
import com.shijia.web.repository.mapper.CustomPageDAO;
import com.shijia.web.repository.mapper.domain.CustomPageDO;
import com.shijia.web.repository.mapper.domain.CustomPageTypeDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author YanxiSir
 * @since 16/12/22
 */
@Service
public class CustomPageService {

    @Autowired
    private CustomPageDAO customPageDAO;

    public int addNewCustomPage(AddOrUpCustomPageReq req){
        CustomPageDO pageDO = new CustomPageDO();
        pageDO.setContent(req.getContent());
        pageDO.setPageNo(req.getPageNo());
        pageDO.setStatus(CustomPageStatusEnum.NOT_USING.value());
        return customPageDAO.insertNewCustomPage(pageDO);
    }
    public int updateCustomPage(AddOrUpCustomPageReq req){
        CustomPageDO pageDO  = new CustomPageDO();
        pageDO.setContent(req.getContent());
        pageDO.setId(req.getId());
        return customPageDAO.updateCustomPageById(pageDO);
    }

    public List<CustomPageTypeDO> getAllPageType() {
        return customPageDAO.selectAllCustomType();
    }

    public CustomPageDO getCustomPageById(int id){
        return customPageDAO.selectCustomPageById(id);
    }
}
