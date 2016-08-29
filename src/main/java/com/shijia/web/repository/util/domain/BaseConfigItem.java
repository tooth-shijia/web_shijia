package com.shijia.web.repository.util.domain;

/**
 * @author YanxiSir
 * @since 16/8/29
 */
public class BaseConfigItem {

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
