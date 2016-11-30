package com.shijia.web.common.cookie;

import com.shijia.web.common.session.SessionAdminMember;
import com.shijia.web.common.utils.ConstantUtils;
import com.shijia.web.common.utils.StringUtils;

/**
 * @author YanxiSir
 * @since 16/5/21
 */
public class CookieAdminBean {

    private final static String AGID = "agid";
    private final static String ADMIN_GUID = "AdminGuid";



    public static String getAdminGuid() {
        String adminGuid = CookieManager.getCookie(ADMIN_GUID);
        if (StringUtils.isEmpty(adminGuid)) {
            adminGuid = ConstantUtils.getUUID();
            CookieManager.setCookie(ADMIN_GUID, adminGuid);
        }
        return adminGuid;
    }

    private static final String USER_NAME = "username";
    private static final String NICK_NAME = "nickname";
    public static void setUgid(SessionAdminMember member) {
        if(member!=null) {
            StringBuilder sbd = new StringBuilder(128);
            sbd.append(USER_NAME).append('=');
            String tmp = member.getUsername();
            if (tmp != null) {
                sbd.append(tmp);
            }
            sbd.append('#').append(NICK_NAME).append('=');
            tmp = member.getNickName();
            if (tmp != null) {
                sbd.append(tmp);
            }
            CookieManager.setCookie(AGID,sbd.toString());
        }
    }



    public static void setAdminGuid(String adminGuid) {
        CookieManager.setCookie(ADMIN_GUID, adminGuid);
    }
}
