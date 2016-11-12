package com.shijia.web.controller.admin;

import com.shijia.web.controller.admin.BaseAdminController;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author YanxiSir
 * @since 16/5/22
 */
@Controller
@RequestMapping("/admin")
public class ProductAboutController extends BaseAdminController {

    @RequestMapping("/productshow")
    public String showProduct() {
        return "admin/productshow";
    }

    @RequestMapping("/productedit")
    public String productEdit(Model model, @RequestParam(required = false) Integer id) {
        if (id != null && id.intValue() > 0) {
            model.addAttribute("id", id);
        } else {
            model.addAttribute("id", -1);
        }
        return "admin/productedit";
    }

}
