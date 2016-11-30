package com.shijia.web.controller.admin;

import com.shijia.web.repository.mapper.domain.NewsShow;
import com.shijia.web.service.CommonService;
import com.shijia.web.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author YanxiSir
 * @since 16/5/21
 */
@Controller
@RequestMapping("/admin")
public class NewsManagerController extends BaseAdminController {

    @Autowired
    private NewsService newsService;
    @Autowired
    private CommonService commonService;

    @RequestMapping("/newsmanager")
    public String newsManager() {

        return "admin/newmanager";
    }

    @RequestMapping("/newsedit")
    public String newsEdit(Model model, @RequestParam(required = false) Integer id) {
        NewsShow ns = new NewsShow();
        if (id!=null && id.intValue() > 0) {
            ns = newsService.getNewsById(id);
            String content = commonService.getURLDecodeString(ns.getContent());
            ns.setContent(content);
            model.addAttribute("id", id);
            model.addAttribute("news", ns);
            model.addAttribute("type", "update");
        } else {
            model.addAttribute("id", -1);
            model.addAttribute("type", "add");
            model.addAttribute("news", ns);
        }
        return "admin/newsedit";
    }
}

