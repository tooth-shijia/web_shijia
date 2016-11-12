package com.shijia.web.controller.admin;

import com.shijia.web.controller.admin.BaseAdminController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author YanxiSir
 * @since 16/5/22
 */
@Controller
@RequestMapping("/admin")
public class ProductAboutController extends BaseAdminController{

    @RequestMapping("/productshow")
    public String showProduct(){
        return "admin/productshow";
    }

    @RequestMapping("/productedit")
    public String productEdit(){
        return "admin/productedit";
    }

}
