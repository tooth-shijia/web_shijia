package com.shijia.web.controller.user;

import org.apache.ibatis.annotations.ResultMap;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Tangxinqi on 2016/7/3.
 */
@Controller
public class MenuListPageController {

    @RequestMapping("web/shijia/companyinfo/gsjj")
    public ModelAndView moveToCompanyInfoPage(){
        ModelAndView model = new ModelAndView("user/companyinfo/gsjj");
        model.addObject("m_title","上海世佳义齿");
        return model;
    }

    @RequestMapping("web/shijia/companyinfo/qywh")
    public ModelAndView moveToCompanyCulture(){
        ModelAndView model = new ModelAndView("user/companyinfo/qywh");
        model.addObject("m_title","上海世佳义齿");
        return model;
    }

    @RequestMapping("web/shijia/product/shijiaproduct")
    public ModelAndView moveToproductShow(){
        ModelAndView model = new ModelAndView("user/product/shijiaproduct");
        model.addObject("m_title","上海世佳义齿");
        return model;
    }

}
