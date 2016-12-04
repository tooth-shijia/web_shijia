package com.shijia.web.controller.admin.domain.login;

/**
 * 管理后台登录 model
 *
 * @author YanxiSir
 * @since 16/5/21
 */
public class LoginAdminReq {

    private String username;
    private String password;
    private boolean isRememberMe;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean getIsRememberMe() {
        return isRememberMe;
    }

    public void setIsRememberMe(boolean isRememberMe) {
        this.isRememberMe = isRememberMe;
    }
}
