package com.shijia.web.controller.admin;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author YanxiSir
 * @since 16/5/21
 */
@Controller
@RequestMapping("/admin")
public class IndexManagerController extends BaseAdminController {

    private static final Logger logger = LoggerFactory.getLogger(IndexManagerController.class);


    @RequestMapping("/index")
    public String index() {

        return "admin/index";
    }
}
