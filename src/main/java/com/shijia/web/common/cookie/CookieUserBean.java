package com.shijia.web.common.cookie;

import com.shijia.web.common.utils.ConstantUtils;
import com.shijia.web.common.utils.StringUtils;

/**
 * @author YanxiSir
 * @since 16/11/30
 */
public class CookieUserBean {


    private final static String UGID = "ugid";
    private final static String COOKIE_GUID = "CookieGuid";

    public static String getUgid() {
        String ugid = CookieManager.getCookie(UGID);
        if (StringUtils.isEmpty(ugid)) {
            ugid = ConstantUtils.getUUID();
            CookieManager.setCookie(UGID, ugid);
        }
        return ugid;
    }

    public static String getCookieGuid() {
        String cookieGuid = CookieManager.getCookie(COOKIE_GUID);
        if (StringUtils.isEmpty(cookieGuid)) {
            cookieGuid = ConstantUtils.getUUID();
            CookieManager.setCookie(COOKIE_GUID, cookieGuid);
        }
        return cookieGuid;
    }

    public static void setCookieGuid(String cookieGuid) {
        CookieManager.setCookie(COOKIE_GUID, cookieGuid);
    }
}
