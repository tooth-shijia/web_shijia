package com.shijia.web.common.session;

import com.shijia.web.common.cookie.CookieAdminBean;
import com.shijia.web.common.utils.StringUtils;

import javax.servlet.http.HttpServletRequest;

/**
 * @author YanxiSir
 * @since 16/5/21
 */
public class SessionAdminManager {

    /**
     * 获取管理员登录信息
     *
     * @param aguid
     * @return
     */
    public static SessionAdminMember getAdminInfo(HttpServletRequest request, String aguid) {
        if (StringUtils.isEmpty(aguid)) return null;
        return (SessionAdminMember) request.getSession().getAttribute(aguid);
    }

    public static void setAdminInfo(HttpServletRequest request, SessionAdminMember member) {
        request.getSession().setAttribute(CookieAdminBean.getAdminGuid(), member);
    }
}
