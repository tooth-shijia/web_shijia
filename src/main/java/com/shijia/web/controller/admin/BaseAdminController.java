package com.shijia.web.controller.admin;

import com.shijia.web.common.cookie.CookieAdminBean;
import com.shijia.web.common.framework.HttpContext;
import com.shijia.web.common.session.SessionAdminMember;
import com.shijia.web.common.session.SessionAdminManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author YanxiSir
 * @since 16/5/21
 */
public class BaseAdminController {

    @ModelAttribute
    public void initController(Model modelAndView) {
        //判断是否登录，没有就跳到admin登录页

        HttpServletRequest request = HttpContext.getRequest();
        HttpServletResponse response = HttpContext.getResponse();
        SessionAdminMember adminMember = SessionAdminManager.getAdminInfo(request, CookieAdminBean.getAdminGuid());
        if (adminMember == null) {
            String host = request.getHeader("host");
            String requestUrl = request.getRequestURL().toString();
            String adminLoginurl = "http://" + host + "/admin/login?backUrl=" + requestUrl;
            try {
                response.sendRedirect(adminLoginurl);
            } catch (Exception e) {

            }
        } else {
            modelAndView.addAttribute("member", adminMember);
        }
    }

    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true));
    }
}
