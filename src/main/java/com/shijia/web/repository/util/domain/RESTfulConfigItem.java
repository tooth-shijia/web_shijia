package com.shijia.web.repository.util.domain;

/**
 * RESTful 请求基本配置
 *
 * @author YanxiSir
 * @since 16/8/25
 */
public class RESTfulConfigItem {

    private String url;
    private int timeout;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getTimeout() {
        return timeout;
    }

    public void setTimeout(int timeout) {
        this.timeout = timeout;
    }
}
