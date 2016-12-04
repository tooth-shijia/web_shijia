package com.shijia.web.controller.user.domain.login;

/**
 * @author YanxiSir
 * @since 16/12/1
 */
public class LoginUserReq {

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
