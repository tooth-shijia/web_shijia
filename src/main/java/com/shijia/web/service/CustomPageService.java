package com.shijia.web.service;

import com.shijia.web.common.consts.enums.CustomPageStatusEnum;
import com.shijia.web.common.utils.CollectionUtils;
import com.shijia.web.common.utils.CustomPageUtils;
import com.shijia.web.common.utils.DateUtils;
import com.shijia.web.controller.admin.domain.custompage.AddOrUpCustomPageReq;
import com.shijia.web.controller.admin.viewmodel.custompage.CustomPageShowItem;
import com.shijia.web.repository.mapper.CustomPageDAO;
import com.shijia.web.repository.mapper.domain.CustomPageDO;
import com.shijia.web.repository.mapper.domain.CustomPageTypeDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author YanxiSir
 * @since 16/12/22
 */
@Service
public class CustomPageService {

    @Autowired
    private CustomPageDAO customPageDAO;
    @Autowired
    private CommonService commonService;

    public int addNewCustomPage(AddOrUpCustomPageReq req) {
        CustomPageDO pageDO = new CustomPageDO();
        pageDO.setContent(req.getContent());
        pageDO.setPageNo(req.getPageNo());
        pageDO.setPageName(req.getPageName());
        pageDO.setStatus(CustomPageStatusEnum.NOT_USING.value());
        return customPageDAO.insertNewCustomPage(pageDO);
    }

    public int updateCustomPage(AddOrUpCustomPageReq req) {
        CustomPageDO pageDO = new CustomPageDO();
        pageDO.setContent(req.getContent());
        pageDO.setId(req.getId());
        return customPageDAO.updateCustomPageById(pageDO);
    }

    public List<CustomPageTypeDO> getAllPageType() {
        return customPageDAO.selectAllCustomType();
    }

    public CustomPageDO getCustomPageById(int id) {
        CustomPageDO pageDO = customPageDAO.selectCustomPageById(id);
        if (pageDO != null) {
            String content = commonService.getURLDecodeString(pageDO.getContent(), 2);
            pageDO.setContent(content);
        }
        return pageDO;
    }

    public CustomPageDO getCustomPageByName(String name) {
        CustomPageDO pageDO = customPageDAO.selectUsingPageByPageNo(name);
        if (pageDO != null) {
            String content = commonService.getURLDecodeString(pageDO.getContent(), 2);
            pageDO.setContent(content);
        }
        return pageDO;
    }

    public List<CustomPageShowItem> getAllVersionPageByPageNo(String pageNo) {
        List<CustomPageShowItem> list = new ArrayList<CustomPageShowItem>();
        List<CustomPageDO> pageDOs = customPageDAO.selectAllVersionByPageNo(pageNo);
        if (CollectionUtils.isNotEmpty(pageDOs)) {
            for (CustomPageDO pageDO : pageDOs) {
                CustomPageShowItem item = new CustomPageShowItem();
                item.setId(pageDO.getId());
                item.setPageNo(pageDO.getPageNo());
                item.setPageName(pageDO.getPageName());
                item.setPageUrl("#");
                item.setStatus(CustomPageUtils.getPageStatus(pageDO.getStatus()));
                item.setCreateTime(DateUtils.getDate(pageDO.getCreateTime()));
                item.setLastModifyTime(DateUtils.getDate(pageDO.getLastModifyTime()));
                list.add(item);
            }
        }
        return list;
    }
}
