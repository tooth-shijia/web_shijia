package com.shijia.web.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author YanxiSir
 * @since 16/12/6
 */
@Controller
@RequestMapping("/web/admin")
public class UserManagerController extends BaseAdminController{

    @RequestMapping("/usermanager")
    public String usermanager(Model model) {

        return "admin/usermanager";
    }
}
