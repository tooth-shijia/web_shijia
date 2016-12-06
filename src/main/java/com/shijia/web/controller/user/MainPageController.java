package com.shijia.web.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Tangxinqi on 2016/6/3.
 */
@Controller
@RequestMapping("/web/shijia")
public class MainPageController  extends  BaseController{

    @RequestMapping("/index")
    public  ModelAndView moveToMainPage(){
         ModelAndView model = new ModelAndView("user/index");
         model.addObject("m_title","上海世佳义齿");
         return model;
     }

    @RequestMapping("/login")
    public  ModelAndView moveToLoginPage(){
        ModelAndView model = new ModelAndView("user/login");
        model.addObject("m_title","登录");
        return model;
    }

    @RequestMapping("/signup")
    public  ModelAndView moveToSignupPage(){
        ModelAndView model = new ModelAndView("user/signup");
        model.addObject("m_title","注册");
        return model;
    }

    @RequestMapping("/forgotpwd")
    public  ModelAndView moveToForgotPwdPage(){
        ModelAndView model = new ModelAndView("user/forgotpwd");
        model.addObject("m_title","找回密码");
        return model;
    }
}
