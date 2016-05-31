package com.shijia.web.common.framework;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author YanxiSir
 * @since 16/5/21
 */
public class HttpContext {

    private static final ThreadLocal<HttpServletRequest> request_threadLocal = new ThreadLocal();
    private static final ThreadLocal<HttpServletResponse> reponse_threadLocal = new ThreadLocal();

    public HttpContext() {
    }

    public static void setRequest(HttpServletRequest request) {
        request_threadLocal.set(request);
    }

    public static HttpServletRequest getRequest() {
        return (HttpServletRequest)request_threadLocal.get();
    }

    public static void removeRequest() {
        request_threadLocal.remove();
    }

    public static void setResponse(HttpServletResponse response) {
        reponse_threadLocal.set(response);
    }

    public static HttpServletResponse getResponse() {
        return (HttpServletResponse)reponse_threadLocal.get();
    }

    public static void removeResponse() {
        reponse_threadLocal.remove();
    }

    public static void clear() {
        removeRequest();
        removeResponse();
    }

    public static void set(HttpServletRequest request, HttpServletResponse response) {
        setRequest(request);
        setResponse(response);
    }
}
