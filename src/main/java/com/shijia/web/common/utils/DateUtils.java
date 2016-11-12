package com.shijia.web.common.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by Tangxinqi on 2016/6/5.
 */
public class DateUtils {

    private final static String[] weekDays = {"星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六"};

    public static String getTodayForString() {
        Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int mon = c.get(Calendar.MONTH) + 1;
        int day = c.get(Calendar.DATE);
        int wk = c.get(Calendar.DAY_OF_WEEK) - 1;
        String week = weekDays[wk];
        String today = year + "年" + mon + "月" + day + "日" + "   " + week;
        return today;
    }

    /**
     * 获取时间 yyyy-HH-dd HH:mm:ss
     *
     * @param date
     * @return
     */
    public static String getDate(Date date) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-hh-dd HH:mm:ss");
        return format.format(date);
    }

    /**
     * 获取当前时间 date
     *
     * @return
     */
    public static Date getCurDate() {
        Calendar c = Calendar.getInstance();
        return c.getTime();
    }
}
