package com.shijia.web.controller.admin;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author YanxiSir
 * @since 16/8/29
 */
@Controller
@RequestMapping("/web/admin")
public class QueryManagerController {

    @RequestMapping("/querymanager")
    public String query(Model model) {

        return "admin/querymanager";
    }
}
