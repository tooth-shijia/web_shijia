package com.shijia.web.controller.admin.ajax;

import com.shijia.web.common.domain.AjaxResult;
import com.shijia.web.common.utils.StringUtils;
import com.shijia.web.repository.mapper.domain.ProductType;
import com.shijia.web.service.domain.productshow.AddProductShowReq;
import com.shijia.web.service.interfaces.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author YanxiSir
 * @since 16/11/9
 */
@Controller
@RequestMapping("/admin/ajax")
public class ProductAboutAjaxController {

    @Autowired
    private IProductService productService;

    @RequestMapping("/addProduct")
    @ResponseBody
    public AjaxResult addProduct(AddProductShowReq req) {
        if (req == null) {
            return new AjaxResult(false, "请求内容为空");
        }
        if (StringUtils.isEmpty(req.getProductName())) {
            return new AjaxResult(false, "产品名为空");
        }
        if (req.getProductTypeId() == 0) {
            return new AjaxResult(false, "请选择产品类型");
        }
        if (StringUtils.isEmpty(req.getContent())) {
            return new AjaxResult(false, "请输入产品描述");
        }
        int result = productService.addProduct(req);
        if (result > 0) {
            return new AjaxResult(true, "添加成功");
        } else {
            return new AjaxResult(false, "添加失败");
        }
    }

    @ResponseBody
    @RequestMapping("/getAllProductType")
    public AjaxResult getProductType() {

        List<ProductType> list = productService.getProductTypeAll();
        if(list == null){
            return new AjaxResult(false,"没有获取到产品类型列表");
        }
        return new AjaxResult(true,"success",list);
    }
}
