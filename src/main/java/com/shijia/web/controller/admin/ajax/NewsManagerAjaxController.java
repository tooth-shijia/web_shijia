package com.shijia.web.controller.admin.ajax;

import com.alibaba.fastjson.JSON;
import com.shijia.web.common.consts.enums.EProductShowReq;
import com.shijia.web.common.domain.AjaxResult;
import com.shijia.web.common.utils.StringUtils;
import com.shijia.web.controller.admin.viewmodel.news.NewsShowModel;
import com.shijia.web.controller.admin.viewmodel.product.PsTotalModel;
import com.shijia.web.service.NewsService;
import com.shijia.web.controller.admin.domain.news.AddOrUpNewsReq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author YanxiSir
 * @since 16/11/29
 */
@Controller
@RequestMapping("/web/admin/ajax/news")
public class NewsManagerAjaxController {

    @Autowired
    private NewsService newsService;

    /**
     * 每页产品数
     */
    private static final int PAGE_SIZE = 50;

    @RequestMapping(value = "/addOrUpNews", method = RequestMethod.POST)
    @ResponseBody
    public AjaxResult addOrUpNews(@RequestBody AddOrUpNewsReq req) {
        if (req == null) {
            return new AjaxResult(false, "请求内容为空");
        }
        if (StringUtils.isEmpty(req.getNewsName())) {
            return new AjaxResult(false, "新闻名不能为空");
        }
        if (StringUtils.isEmpty(req.getContent())) {
            return new AjaxResult(false, "请输入新闻描述");
        }
        int result = -1;
        String operate = "";
        if (req.getReqType() == EProductShowReq.REQ_ADD.value()) {
            operate = "新闻新增";
            result = newsService.addNews(req);
        } else if (req.getReqType() == EProductShowReq.REQ_UPDATE.value()) {
            operate = "新闻更新";
            result = newsService.updateNewsById(req);
        }
        if (result > 0) {
            return new AjaxResult(true, operate + "成功");
        } else {
            return new AjaxResult(false, operate + "失败");
        }
    }

    @ResponseBody
    @RequestMapping("/getNewsShow")
    public AjaxResult getNewsShow(int pageIndex, int newsType) {
        if (pageIndex <= 0) {
            pageIndex = 1;
        }
        List<NewsShowModel> list = newsService.getNewsByPageAndType(pageIndex, PAGE_SIZE, newsType);
        if (list == null) {
            return new AjaxResult(false, "查询异常", null);
        }
        if (list.size() == 0) {
            return new AjaxResult(false, "没有获取到数据", null);
        }
        return new AjaxResult(true, "success", list);
    }

    @ResponseBody
    @RequestMapping("/getTotalByTypeId")
    public AjaxResult getTotalByTypeId(int newsTypeId) {
        PsTotalModel psTotalModel = new PsTotalModel();
        int total = newsService.getTotalCountByTypeId(newsTypeId);
        if (total >= 0) {
            int pageSize = total / PAGE_SIZE + (total % PAGE_SIZE > 0 ? 1 : 0);
            psTotalModel.setTotal(total);
            psTotalModel.setPageSize(pageSize);
            return new AjaxResult(true, "success", psTotalModel);
        } else {
            return new AjaxResult(false, "查询总数异常", psTotalModel);
        }
    }

    @ResponseBody
    @RequestMapping("/delNewsById")
    public AjaxResult delProductById(Integer id) {
        if (id == null || id.intValue() <= 0) {
            return new AjaxResult(false, "id不能为空");
        }
        int result = newsService.delNewsShowById(id);
        if (result < 0) {
            return new AjaxResult(false, "删除失败");
        } else if (result == 0) {
            return new AjaxResult(false, "没有找到该条记录");
        } else {
            return new AjaxResult(true, "删除成功");
        }
    }

    @ResponseBody
    @RequestMapping("/recoverNewsById")
    public AjaxResult recoverProductShowById(Integer id) {
        if (id == null || id.intValue() <= 0) {
            return new AjaxResult(false, "id不能为空");
        }
        int result = newsService.recoverNewsShowById(id);
        if (result < 0) {
            return new AjaxResult(false, "恢复失败");
        } else if (result == 0) {
            return new AjaxResult(false, "没有找到该条记录");
        } else {
            return new AjaxResult(true, "恢复成功");
        }
    }
}
