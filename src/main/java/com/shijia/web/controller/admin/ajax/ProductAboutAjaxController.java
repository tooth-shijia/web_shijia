package com.shijia.web.controller.admin.ajax;

import com.alibaba.fastjson.JSON;
import com.shijia.web.common.consts.enums.EProductShowReq;
import com.shijia.web.common.domain.AjaxResult;
import com.shijia.web.common.utils.StringUtils;
import com.shijia.web.controller.admin.viewmodel.product.ProductShowModel;
import com.shijia.web.controller.admin.viewmodel.product.ProductTypeModel;
import com.shijia.web.controller.admin.viewmodel.product.PsTotalModel;
import com.shijia.web.service.ProductService;
import com.shijia.web.controller.admin.domain.productshow.AddOrUpProductShowReq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author YanxiSir
 * @since 16/11/9
 */
@Controller
@RequestMapping("/web/admin/ajax/product")
public class ProductAboutAjaxController {

    @Autowired
    private ProductService productService;

    /**
     * 每页产品数
     */
    private static final int PAGE_SIZE = 50;

    @RequestMapping(value = "/addOrUpProduct", method = RequestMethod.POST)
    @ResponseBody
    public AjaxResult addProduct(@RequestBody AddOrUpProductShowReq req) {
        if (req == null) {
            return new AjaxResult(false, "请求内容为空");
        }
        if (StringUtils.isEmpty(req.getProductName())) {
            return new AjaxResult(false, "产品名不能为空");
        }
        if (StringUtils.isEmpty(req.getProductId())) {
            return new AjaxResult(false, "产品名不能为空");
        }
        if (req.getProductTypeId() == 0) {
            return new AjaxResult(false, "请选择产品类型");
        }
        if (StringUtils.isEmpty(req.getContent())) {
            return new AjaxResult(false, "请输入产品描述");
        }
        int result = -1;
        String operate = "";
        if (req.getReqType() == EProductShowReq.REQ_ADD.value()) {
            operate = "新增";
            result = productService.addProduct(req);
        } else if (req.getReqType() == EProductShowReq.REQ_UPDATE.value()) {
            operate = "更新";
            result = productService.updateProductShowById(req);
        }
        if (result > 0) {
            return new AjaxResult(true, operate + "成功");
        } else {
            return new AjaxResult(false, operate + "失败");
        }

    }

    @ResponseBody
    @RequestMapping("/getAllProductType")
    public AjaxResult getProductType(int siteId, int parentId) {

        List<ProductTypeModel> list = productService.getProductTypeAll(siteId, parentId);
        if (list == null) {
            return new AjaxResult(false, "没有获取到产品类型列表");
        }
        return new AjaxResult(true, "success", list);
    }

    @ResponseBody
    @RequestMapping("/getProductShow")
    public AjaxResult getProductShow(int pageIndex, int productType) {
        if (pageIndex <= 0) {
            pageIndex = 1;
        }
        List<ProductShowModel> list = productService.getProductByPageAndType(pageIndex, PAGE_SIZE, productType);
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
    public AjaxResult getTotalByTypeId(int productTypeId) {
        PsTotalModel psTotalModel = new PsTotalModel();
        int total = productService.getTotalCountByTypeId(productTypeId);
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
    @RequestMapping("/delProductById")
    public AjaxResult delProductById(Integer id) {
        if (id == null || id.intValue() <= 0) {
            return new AjaxResult(false, "id不能为空");
        }
        int result = productService.delProductShowById(id);
        if (result < 0) {
            return new AjaxResult(false, "删除失败");
        } else if (result == 0) {
            return new AjaxResult(false, "没有找到该条记录");
        } else {
            return new AjaxResult(true, "删除成功");
        }
    }

    @ResponseBody
    @RequestMapping("/recoverProductById")
    public AjaxResult recoverProductShowById(Integer id) {
        if (id == null || id.intValue() <= 0) {
            return new AjaxResult(false, "id不能为空");
        }
        int result = productService.recoverProductShowById(id);
        if (result < 0) {
            return new AjaxResult(false, "恢复失败");
        } else if (result == 0) {
            return new AjaxResult(false, "没有找到该条记录");
        } else {
            return new AjaxResult(true, "恢复成功");
        }
    }

}
