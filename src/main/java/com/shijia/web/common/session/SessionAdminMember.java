package com.shijia.web.common.session;

/**
 * @author YanxiSir
 * @since 16/5/21
 */
public class SessionAdminMember {

    /**
     * 登录名
     */
    private String username;

    /**
     * 昵称
     */
    private String nickName;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }
}
