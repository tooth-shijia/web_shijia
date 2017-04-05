package com.shijia.web.controller.admin;

import com.shijia.web.repository.mapper.domain.ProductShow;
import com.shijia.web.service.CommonService;
import com.shijia.web.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


/**
 * @author YanxiSir
 * @since 16/5/22
 */
@Controller
@RequestMapping("/web/admin")
public class ProductAboutController extends BaseAdminController {

    @Autowired
    private ProductService productService;
    @Autowired
    private CommonService commonService;

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
            productShow.setCoverImage("/web/image/product/show/" + productShow.getCoverImage());
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
