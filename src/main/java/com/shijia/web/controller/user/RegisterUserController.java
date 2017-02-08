package com.shijia.web.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * author: yanxi
 * date : 17/2/8
 */
@Controller
@RequestMapping("/web/shijia")
public class RegisterUserController{

    @RequestMapping("/signup")
    public ModelAndView moveToSignupPage(){
        ModelAndView model = new ModelAndView("user/signup");
        model.addObject("m_title","注册");
        return model;
    }
}
