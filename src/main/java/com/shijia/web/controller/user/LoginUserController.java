package com.shijia.web.controller.user;

import com.shijia.web.service.LoginUserService;
import com.shijia.web.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author YanxiSir
 * @since 16/11/30
 */
@Controller
public class LoginUserController {

    @Autowired
    private UserInfoService userInfoService;

    @ResponseBody
    @RequestMapping("/user/info")
    public Object getUserInfo(String value){
        return userInfoService.getUserInfoByPhone(value);
    }
}
