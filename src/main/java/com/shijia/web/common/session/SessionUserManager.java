package com.shijia.web.common.session;

import com.shijia.web.common.cookie.CookieUserBean;
import com.shijia.web.common.utils.StringUtils;

import javax.servlet.http.HttpServletRequest;

/**
 * @author YanxiSir
 * @since 16/11/30
 */
public class SessionUserManager {

    /**
     * 获取管理员登录信息
     *
     * @param uguid
     * @return
     */
    public static SessionUserMember getUserInfo(HttpServletRequest request, String uguid) {
        if (StringUtils.isEmpty(uguid)) return null;
        return (SessionUserMember) request.getSession().getAttribute(uguid);
    }

    public static void setUserInfo(HttpServletRequest request, SessionUserMember member) {
        request.getSession().setAttribute(CookieUserBean.getUgid(), member);
    }
}
