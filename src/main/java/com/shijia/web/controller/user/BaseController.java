package com.shijia.web.controller.user;

import com.shijia.web.common.utils.DateUtils;
import com.shijia.web.repository.dao.DataPersistenceManager;
import com.shijia.web.repository.dao.DataPersistenceObject;
import com.shijia.web.repository.dao.Users;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;

/**
 * Created by Tangxinqi on 2016/6/3.
 */
public class BaseController {

    @ModelAttribute
    public void initController(Model modelAndView) {


        modelAndView.addAttribute("time","<div>"+DateUtils.getTodayForString()+"</div>");
        if(true){
            String login = "<div>"
                    +"<a href=\"/shijia/login.html\"><span class=\"glyphicon glyphicon-log-in\" ></span>Login</a>"
                    +"<a href=\"/shijia/signup.html\"><span class=\"glyphicon glyphicon-edit\" ></span>Sign up</a>"
                    +"</div>";
            modelAndView.addAttribute("login",login);
        }
//        DataPersistenceObject dpo = DataPersistenceManager.getInstance().getDataPersistenceObject();
////        DataPersistenceMySqlObjectImpl dpo = new DataPersistenceMySqlObjectImpl();
//        Users user = (Users)dpo.selectById("111","users",Users.class);
//        System.out.println(user.getUsr_name());
////
////        System.out.println(user.getId());
    }
}
