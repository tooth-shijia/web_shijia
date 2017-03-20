package com.shijia.web.controller.user;

import com.shijia.web.common.consts.enums.CustomPageEnum;
import com.shijia.web.controller.user.viewmodel.BaseDTO;
import com.shijia.web.repository.mapper.domain.CustomPageDO;
import com.shijia.web.service.CustomPageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author YanxiSir
 * @since 17/3/20
 */
@Controller
@RequestMapping("/web/shijia")
public class CustomPageController {

    @Autowired
    private CustomPageService customPageService;

    @RequestMapping("/custom/{name}")
    public ModelAndView custom(@PathVariable String name) {
        ModelAndView model = new ModelAndView("h5/custom-page");
        CustomPageEnum pageEnum = CustomPageEnum.transfer(name);
        CustomPageDO pageDO = customPageService.getCustomPageByName(pageEnum.value().toUpperCase());
        model.addObject("mv", pageDO);
        return model;
    }
}
