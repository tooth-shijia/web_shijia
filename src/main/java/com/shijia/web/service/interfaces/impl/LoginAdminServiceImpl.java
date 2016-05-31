package com.shijia.web.service.interfaces.impl;

import com.shijia.web.common.cookie.CookieManageBean;
import com.shijia.web.common.session.SessionAdminMember;
import com.shijia.web.common.session.SessionManager;
import com.shijia.web.controller.viewmodel.admin.login.LoginAdminReqModel;
import com.shijia.web.service.interfaces.ILoginAdminService;
import org.springframework.stereotype.Service;

/**
 * @author YanxiSir
 * @since 16/5/21
 */
@Service("loginAdminServiceImpl")
public class LoginAdminServiceImpl implements ILoginAdminService {

    public boolean setLoginStatus(LoginAdminReqModel model) {
        SessionAdminMember member = new SessionAdminMember();
        member.setUsername(model.getUsername());
        member.setNickName(model.getUsername());
        SessionManager.setAdminInfo(member);
        CookieManageBean.setUgid(member);
        return true;
    }
}
