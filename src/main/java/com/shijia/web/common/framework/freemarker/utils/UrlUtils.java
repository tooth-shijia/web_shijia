package com.shijia.web.common.framework.freemarker.utils;

/**
 * @author YanxiSir
 * @since 16/8/25
 */
public class UrlUtils {

    public static String getUserJs(String name) {

        String prefix = "/ujs/";
        return prefix + name;
    }
}
