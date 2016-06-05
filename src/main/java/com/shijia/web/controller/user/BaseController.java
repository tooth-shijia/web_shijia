package com.shijia.web.controller.user;

import com.shijia.web.common.framework.HttpContext;
import com.shijia.web.common.utils.DateUtils;
import org.apache.commons.httpclient.HttpClient;
import org.springframework.http.HttpRequest;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.servlet.http.HttpServletRequest;
import java.util.Calendar;

/**
 * Created by Tangxinqi on 2016/6/3.
 */
public class BaseController {

    @ModelAttribute
    public void initController(Model modelAndView) {


        modelAndView.addAttribute("time","<div>"+DateUtils.getTodayForString()+"</div>");
        if(true){
            String login = "<div>"
                    +"<a href=\"/shijia/login.html\"><img src=\"/uimg/loginico.png\" >Login</a>"
                    +"<a href=\"/shijia/signup.html\"><img src=\"/uimg/signup.png\" >Sign up</a>"
                    +"</div>";
            modelAndView.addAttribute("login",login);
        }

    }
}
