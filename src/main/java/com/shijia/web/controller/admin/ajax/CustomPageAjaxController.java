package com.shijia.web.controller.admin.ajax;

import com.shijia.web.common.domain.AjaxResult;
import com.shijia.web.common.utils.StringUtils;
import com.shijia.web.controller.admin.domain.custompage.AddOrUpCustomPageReq;
import com.shijia.web.controller.admin.viewmodel.custompage.CustomPageShowItem;
import com.shijia.web.repository.mapper.domain.CustomPageDO;
import com.shijia.web.repository.mapper.domain.CustomPageTypeDO;
import com.shijia.web.service.CustomPageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * @author YanxiSir
 * @since 16/12/22
 */
@Controller
@RequestMapping("/web/admin/ajax/cp")
public class CustomPageAjaxController {

    @Autowired
    private CustomPageService customPageService;

    @ResponseBody
    @RequestMapping("/addOrUpCustomPage")
    public Object addOrUpCustomPage(@RequestBody AddOrUpCustomPageReq req) {
        if (StringUtils.isEmpty(req.getPageNo())) {
            return new AjaxResult(false, "页面类型不能为空");
        }
        if (StringUtils.isEmpty(req.getContent())) {
            return new AjaxResult(false, "页面内容不能为空");
        }
        int result = -1;
        String operate = "";
        if (req.getReqType() == 1) {
            operate = "新增";
            result = customPageService.addNewCustomPage(req);
        } else if (req.getReqType() == 2) {
            operate = "更新";
            result = customPageService.updateCustomPage(req);
        }
        if (result > 0) {
            return new AjaxResult(true, operate + "成功");
        } else {
            return new AjaxResult(false, operate + "失败");
        }
    }

    @ResponseBody
    @RequestMapping("/getCustomPageShow")
    public Object getCustomPageShow(String pageNo) {
        List<CustomPageShowItem> list = new ArrayList<CustomPageShowItem>();
        if (StringUtils.isNotEmpty(pageNo)) {
            list = customPageService.getAllVersionPageByPageNo(pageNo);
        }
        return new AjaxResult(true, "", list);
    }

    @ResponseBody
    @RequestMapping("/getCustomPageType")
    public Object getCustomPageType() {
        List<CustomPageTypeDO> list = customPageService.getAllPageType();
        return new AjaxResult(true, "", list);
    }
}
