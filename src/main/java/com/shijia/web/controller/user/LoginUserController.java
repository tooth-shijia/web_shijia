package com.shijia.web.controller.user;

import com.shijia.web.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author YanxiSir
 * @since 16/11/30
 */
@Controller
@RequestMapping("/web/shijia")
public class LoginUserController{

    @Autowired
    private UserInfoService userInfoService;

    @RequestMapping("/login")
    public ModelAndView moveToLoginPage(){
        ModelAndView model = new ModelAndView("user/login");
        model.addObject("m_title","登录");
        return model;
    }

    @ResponseBody
    @RequestMapping("/user/info")
    public Object getUserInfo(String value) {
        return userInfoService.getUserInfoByPhone(value);
    }
}
