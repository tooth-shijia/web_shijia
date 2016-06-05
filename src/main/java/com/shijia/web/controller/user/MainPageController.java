package com.shijia.web.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Tangxinqi on 2016/6/3.
 */
@Controller
@RequestMapping("/shijia")
public class MainPageController  extends  BaseController{

    @RequestMapping("/index")
    public  String moveToMainPage(){

         return "user/index";
     }

}
