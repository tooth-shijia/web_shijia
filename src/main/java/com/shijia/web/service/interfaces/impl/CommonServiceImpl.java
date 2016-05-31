package com.shijia.web.service.interfaces.impl;

import com.shijia.web.common.utils.LogHelper;
import com.shijia.web.common.utils.StringUtils;
import com.shijia.web.service.interfaces.ICommonService;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

/**
 * @author YanxiSir
 * @since 16/5/21
 */
@Service("commonService")
public class CommonServiceImpl implements ICommonService {

    public String getURLEncodeString(String text) {
        if (StringUtils.isEmpty(text)) {
            return "";
        }
        try {
            return URLEncoder.encode(text, "utf-8");
        } catch (UnsupportedEncodingException e) {
            LogHelper.error("CommonServiceImpl - getURLEncodeString异常", e);
        }
        return "";
    }

    public String getURLDecodeString(String text) {
        if (StringUtils.isEmpty(text)) {
            return "";
        }
        try {
            return URLDecoder.decode(text, "utf-8");
        } catch (UnsupportedEncodingException e) {
            LogHelper.error("CommonServiceImpl - getURLDecodeString异常", e);
        }
        return "";
    }
}
