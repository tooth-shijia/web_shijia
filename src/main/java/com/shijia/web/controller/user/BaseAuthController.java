package com.shijia.web.controller.user;

import com.shijia.web.common.cookie.CookieUserBean;
import com.shijia.web.common.framework.HttpContext;
import com.shijia.web.common.session.SessionUserManager;
import com.shijia.web.common.session.SessionUserMember;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 需要强制登录的页面继承该Controller
 * author: yanxi
 * date : 17/2/8
 */
public class BaseAuthController {

    @ModelAttribute
    public void initController(Model modelAndView) {
        //判断是否登录，没有就跳到admin登录页

        HttpServletRequest request = HttpContext.getRequest();
        HttpServletResponse response = HttpContext.getResponse();
        SessionUserMember userMember = SessionUserManager.getUserInfo(request, CookieUserBean.getUgid());
        if (userMember == null) {
            String host = request.getHeader("host");
            String requestUrl = request.getRequestURL().toString();
            String adminLoginurl = "http://" + host + "/web/shijia/login?backUrl=" + requestUrl;
            try {
                response.sendRedirect(adminLoginurl);
            } catch (Exception e) {

            }
        } else {
            modelAndView.addAttribute("member", userMember);
        }

    }
}
