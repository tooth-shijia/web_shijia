package com.shijia.web.controller.admin;

import com.shijia.web.repository.mapper.domain.CustomPageDO;
import com.shijia.web.service.CommonService;
import com.shijia.web.service.CustomPageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author YanxiSir
 * @since 16/12/11
 */
@Controller
@RequestMapping("/web/admin")
public class CustomerPageController {

    @Autowired
    private CustomPageService customPageService;

    @Autowired
    private CommonService commonService;

    @RequestMapping("/custompage")
    public String customerPage(Model model) {

        return "admin/custompage";
    }

    @RequestMapping("/custompageedit")
    public String customerPageEdit(Model model, @RequestParam(required = false) Integer id) {

        CustomPageDO pageDO = null;
        if (id != null && id.intValue() > 0) {
            pageDO = customPageService.getCustomPageById(id);
        }
        if (pageDO != null) {
            String content = commonService.getURLDecodeString(pageDO.getContent(), 2);
            pageDO.setContent(content);
            model.addAttribute("id", id);
            model.addAttribute("page", pageDO);
            model.addAttribute("type", "update");
            model.addAttribute("pageNo", pageDO.getPageNo());
        } else {
            model.addAttribute("id", -1);
            model.addAttribute("type", "add");
            model.addAttribute("page", pageDO);
        }
        return "admin/custompageedit";
    }
}
