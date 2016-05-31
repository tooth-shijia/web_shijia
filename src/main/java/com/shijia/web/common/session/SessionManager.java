package com.shijia.web.common.session;

import com.shijia.web.common.cookie.CookieManageBean;
import com.shijia.web.common.framework.HttpContext;
import com.shijia.web.common.utils.StringUtils;

import javax.servlet.http.HttpServletRequest;

/**
 * @author YanxiSir
 * @since 16/5/21
 */
public class SessionManager {

    /**
     * 获取管理员登录信息
     *
     * @param aguid
     * @return
     */
    public static SessionAdminMember getAdminInfo(String aguid) {
        if (StringUtils.isEmpty(aguid)) return null;
        HttpServletRequest request = HttpContext.getRequest();
        if (request == null) return null;
        return (SessionAdminMember) request.getSession().getAttribute(aguid);
    }

    public static void setAdminInfo(SessionAdminMember member){
        HttpServletRequest request = HttpContext.getRequest();
        if (request == null) return ;
        request.getSession().setAttribute(CookieManageBean.getAdminGuid(),member);
    }
}
