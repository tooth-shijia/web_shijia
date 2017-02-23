package com.shijia.web.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Tangxinqi on 2016/6/3.
 */
@Controller
@RequestMapping("/web/shijia")
public class IndexController extends  BaseController{

    @RequestMapping("/index")
    public  ModelAndView moveToMainPage(){
         ModelAndView model = new ModelAndView("h5/index");
         model.addObject("m_title","上海世佳义齿");
         return model;
     }
}
