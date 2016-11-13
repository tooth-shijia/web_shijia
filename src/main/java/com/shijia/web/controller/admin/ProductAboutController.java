package com.shijia.web.controller.admin;

import com.shijia.web.controller.admin.BaseAdminController;
import com.shijia.web.repository.mapper.domain.ProductShow;
import com.shijia.web.service.interfaces.ICommonService;
import com.shijia.web.service.interfaces.IProductService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.net.URLDecoder;

/**
 * @author YanxiSir
 * @since 16/5/22
 */
@Controller
@RequestMapping("/admin")
public class ProductAboutController extends BaseAdminController {

    @Autowired
    private IProductService productService;
    @Autowired
    private ICommonService commonService;

    @RequestMapping("/productshow")
    public String showProduct(@RequestParam(required = false) Integer id) {
        if (id != null && id.intValue() > 0) {
        }
        return "admin/productshow";
    }

    @RequestMapping("/productedit")
    public String productEdit(Model model, @RequestParam(required = false) Integer id) {
        ProductShow productShow = new ProductShow();
        if (id != null && id.intValue() > 0) {
            productShow = productService.getProductById(id);
            String content = commonService.getURLDecodeString(productShow.getContent());
            productShow.setContent(content);
            model.addAttribute("id", id);
            model.addAttribute("product", productShow);
            model.addAttribute("type", "update");
        } else {
            model.addAttribute("id", -1);
            model.addAttribute("type", "add");
            model.addAttribute("product", productShow);
        }
        return "admin/productedit";
    }

}
