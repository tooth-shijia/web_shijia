package com.shijia.web.common.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * @author YanxiSir
 * @since 16/3/27.
 */
public class LogHelper {

    static Logger applicationLogger = LoggerFactory.getLogger("ApplicationLogger");


    public static void error(String content, Throwable e) {
        if (StringUtils.isEmpty(content))
            return;

        applicationLogger.error(content, e);
    }

    public static void error(String content) {
        if (StringUtils.isEmpty(content))
            return;
        applicationLogger.error(content);
    }

    public static void info(String content) {
        if (StringUtils.isEmpty(content))
            return;
        applicationLogger.info(content);
    }
}
