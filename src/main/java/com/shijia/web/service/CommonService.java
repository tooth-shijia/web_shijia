package com.shijia.web.service;

import com.shijia.web.common.utils.LogHelper;
import com.shijia.web.common.utils.StringUtils;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

/**
 * @author YanxiSir
 * @since 16/5/21
 */
@Service
public class CommonService {

    public String getURLEncodeString(String text) {
        if (StringUtils.isEmpty(text)) {
            return "";
        }
        try {
            return URLEncoder.encode(text, "utf-8");
        } catch (UnsupportedEncodingException e) {
            LogHelper.error("CommonService - getURLEncodeString异常", e);
        }
        return "";
    }

    public String getURLDecodeString(String text) {
        return getURLDecodeString(text, 1);
    }

    public String getURLDecodeString(String text, int time) {
        if (StringUtils.isEmpty(text) || time <= 0) {
            return "";
        }
        try {
            for (int i = 0; i < time; i++) {
                text = URLDecoder.decode(text, "utf-8");
            }
            return text;
        } catch (UnsupportedEncodingException e) {
            LogHelper.error("CommonService - getURLDecodeString异常", e);
        }
        return "";
    }
}
