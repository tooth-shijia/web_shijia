package com.shijia.web.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author YanxiSir
 * @since 16/5/21
 */
@Controller
@RequestMapping("/admin")
public class NewsManagerController extends BaseAdminController {


    @RequestMapping("/newsmanager/{type}")
    public String newsManager(Model model,@PathVariable String type){

        model.addAttribute("type",type);

        return "admin/newmanager";
    }
}

