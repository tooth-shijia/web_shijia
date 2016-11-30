package com.shijia.web.service;

import com.shijia.web.common.cookie.CookieManageBean;
import com.shijia.web.common.session.SessionAdminMember;
import com.shijia.web.common.session.SessionManager;
import com.shijia.web.controller.admin.viewmodel.login.LoginAdminReqModel;
import org.springframework.stereotype.Service;

/**
 * @author YanxiSir
 * @since 16/5/21
 */
@Service("loginAdminService")
public class LoginAdminService  {

    public boolean setLoginStatus(LoginAdminReqModel model) {
        SessionAdminMember member = new SessionAdminMember();
        member.setUsername(model.getUsername());
        member.setNickName(model.getUsername());
        SessionManager.setAdminInfo(member);
        CookieManageBean.setUgid(member);
        return true;
    }
}
