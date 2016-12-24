package com.shijia.web.common.utils;


/**
 * @author YanxiSir
 * @since 16/12/25
 */
public class CustomPageUtils {

    public static String getPageStatus(int status) {
        String des = "";
        if (status == -1) {
            des = "已删除";
        } else if (status == 1) {
            des = "启用中";
        } else if (status == 2) {
            des = "未启用";
        }
        return des;
    }
}
