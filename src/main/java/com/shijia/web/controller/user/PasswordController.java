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
public class PasswordController {

    @RequestMapping("/forgotpwd")
    public ModelAndView moveToForgotPwdPage() {
        ModelAndView model = new ModelAndView("user/forgotpwd");
        model.addObject("m_title", "找回密码");
        return model;
    }
}
