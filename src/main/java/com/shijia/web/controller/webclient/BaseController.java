package com.shijia.web.controller.webclient;

import com.shijia.web.common.utils.DateUtils;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.Calendar;

/**
 * Created by Tangxinqi on 2016/6/3.
 */
public class BaseController {

    @ModelAttribute
    public void initController(Model modelAndView) {


        modelAndView.addAttribute("time","<div>"+DateUtils.getTodayForString()+"</div>");


    }
}
