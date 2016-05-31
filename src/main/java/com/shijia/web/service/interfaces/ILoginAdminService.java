package com.shijia.web.service.interfaces;

import com.shijia.web.controller.viewmodel.admin.login.LoginAdminReqModel;

/**
 * @author YanxiSir
 * @since 16/5/21
 */
public interface ILoginAdminService {

    public boolean setLoginStatus(LoginAdminReqModel model);
}
