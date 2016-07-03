package com.shijia.web.controller.user;

import org.apache.ibatis.annotations.ResultMap;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Tangxinqi on 2016/7/3.
 */
@Controller
@RequestMapping("/shijia/companyinfo")
public class MenuListPageController {

    @RequestMapping("/gsjj")
    public ModelAndView moveToCompanyInfoPage(){
        ModelAndView model = new ModelAndView("user/companyinfo/gsjj");
        model.addObject("m_title","上海世佳义齿");
        return model;
    }

}
