package com.shijia.web.service;

import com.shijia.web.common.cookie.CookieAdminBean;
import com.shijia.web.common.session.SessionAdminMember;
import com.shijia.web.common.session.SessionAdminManager;
import com.shijia.web.controller.admin.viewmodel.login.LoginAdminReqModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

/**
 * @author YanxiSir
 * @since 16/5/21
 */
@Service
public class LoginAdminService {

    @Autowired
    HttpServletRequest request;

    public boolean setLoginStatus(LoginAdminReqModel model) {
        SessionAdminMember member = new SessionAdminMember();
        member.setUsername(model.getUsername());
        member.setNickName(model.getUsername());
        SessionAdminManager.setAdminInfo(request, member);
        CookieAdminBean.setUgid(member);
        return true;
    }
}
