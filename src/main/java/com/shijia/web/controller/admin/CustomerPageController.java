package com.shijia.web.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author YanxiSir
 * @since 16/12/11
 */
@Controller
@RequestMapping("/web/admin")
public class CustomerPageController {

    @RequestMapping("/customerpage")
    public String customerPage(Model model) {

        return "admin/customerpage";
    }

    @RequestMapping("/customerpageedit")
    public String customerPageEdit(Model model) {

        return "admin/customerpageedit";
    }
}
