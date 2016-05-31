package com.shijia.web.common.cookie;

import com.shijia.web.common.framework.HttpContext;
import com.shijia.web.common.utils.LogHelper;
import com.shijia.web.common.utils.StringUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author YanxiSir
 * @since 16/5/21
 */
public class CookieManager {

    private static final Pattern PARAMS_PATTERN = Pattern.compile("([^\\=\\&]+)=([^\\&]*)");
    private static final Pattern pattern = Pattern.compile(".[.]([^.]+[.][^.]+$)");
    private static final Pattern COOKIE_PATTERN = Pattern.compile("([^\\=\\;]+)=([^\\;]*)");
    private static final Pattern XSSDEFENDER = Pattern.compile("[<>]+");

    public CookieManager() {
    }

    private static String Map2String(Map<String, String> map) {
        if(map != null && !map.isEmpty()) {
            StringBuilder tag = new StringBuilder(Math.max(map.size() << 4, 16));
            Iterator i$ = map.entrySet().iterator();

            while(i$.hasNext()) {
                Map.Entry item = (Map.Entry)i$.next();
                String val = (String)item.getValue();
                tag.append('&').append((String)item.getKey()).append('=');
                if(StringUtils.isNotEmpty(val)) {
                    try {
                        tag.append(URLEncoder.encode(val, "UTF-8"));
                    } catch (UnsupportedEncodingException var6) {
                        LogHelper.error("error in encode " + val, var6);
                    }
                }
            }

            return tag.charAt(0) == 38?tag.substring(1):tag.toString();
        } else {
            return "";
        }
    }

    public static String getValFromString(String mapstr, String key, boolean caseignore) {
        if(StringUtils.isAnyEmpty(new CharSequence[]{mapstr, key})) {
            return null;
        } else {
            Matcher matcher = PARAMS_PATTERN.matcher(mapstr);

            while(true) {
                try {
                    if(matcher.find()) {
                        String e = matcher.group(1);
                        if(caseignore) {
                            if(!key.equalsIgnoreCase(e)) {
                                continue;
                            }
                        } else if(!key.equals(e)) {
                            continue;
                        }

                        String value = matcher.group(2);

                        try {
                            return URLDecoder.decode(value, "UTF-8");
                        } catch (UnsupportedEncodingException var7) {
                            LogHelper.error("error in decode value:" + value + ",key:" + key, var7);
                            return null;
                        }
                    }
                } catch (Exception var8) {
                    LogHelper.error("error in getValFromString(mapstr,key) mapstr:" + mapstr + ",key:" + key, var8);
                }

                return null;
            }
        }
    }

    public static Map<String, String> String2Map(String mapstr) {
        HashMap map = new HashMap();
        if(StringUtils.isEmpty(mapstr)) {
            return map;
        } else {
            Matcher matcher = PARAMS_PATTERN.matcher(mapstr);

            while(matcher.find()) {
                String key = matcher.group(1);
                String value = matcher.group(2);

                try {
                    map.put(key, URLDecoder.decode(value, "UTF-8"));
                } catch (UnsupportedEncodingException var6) {
                    LogHelper.error("error in decode value:" + value + ",key:" + key, var6);
                }
            }

            return map;
        }
    }

    public static void setCookie(String cookieName, String cookieValue, int expire) {
        setCookie(cookieName, (String)cookieValue, expire, false, (String)null);
    }

    public static void setCookie(String cookieName, String cookieValue, int expire, String domain) {
        setCookie(cookieName, cookieValue, expire, false, domain);
    }

    public static void setCookie(String cookieName, String cookieValue) {
        setCookie(cookieName, cookieValue, -1);
    }

    public static void delCookie(String cookieName) {
        setCookie(cookieName, (String)null, 0);
    }

    public static void setCookie(String cookieName, String cookieValue, int expire, boolean isHttponly) {
        setCookie(cookieName, (String)cookieValue, expire, isHttponly, (String)null);
    }

    public static void setCookie(String cookieName, String cookieValue, int expire, boolean isHttponly, String domain) {
        setMultiCookie(cookieName, cookieValue, expire, isHttponly, domain);
    }

    private static void setMultiCookie(String cookieName, String cookieValue, int expire, boolean isHttponly, String domain) {
        if(!StringUtils.isAnyEmpty(new CharSequence[]{cookieName, cookieValue})) {
            HttpServletResponse response = HttpContext.getResponse();
            if(response != null) {
                try {
                    Cookie e = new Cookie(cookieName, cookieValue);
                    e.setPath("/");
                    e.setMaxAge(expire);
                    e.setHttpOnly(isHttponly);
                    e.setDomain(checkDomain(domain, HttpContext.getRequest()));
                    response.addCookie(e);
                } catch (Exception var7) {
                    LogHelper.error("cookie decode error:" + cookieValue, var7);
                }

            } else {
                throw new IllegalStateException("none request found from HttpContext.getRequest()");
            }
        }
    }

    private static String checkDomain(String domain, HttpServletRequest request) {
        String cookiedomain = domain;
        if(StringUtils.isEmpty(domain)) {
            URI uri = URI.create(request.getRequestURL().toString());
            cookiedomain = uri.getHost();
            Matcher matcher = pattern.matcher(cookiedomain);
            if(matcher.find()) {
                cookiedomain = matcher.group(1);
            }
        }

        return cookiedomain;
    }

    public static void setCookie(String cookieName, Map<String, String> cookieMap, int expire, boolean isHttponly) {
        setCookie(cookieName, (Map)cookieMap, expire, isHttponly, (String)null);
    }

    public static void setCookie(String cookieName, Map<String, String> cookieMap, int expire, boolean isHttponly, String domain) {
        if(cookieMap.size() == 1) {
            Iterator i$ = cookieMap.values().iterator();
            if(i$.hasNext()) {
                String val = (String)i$.next();
                setMultiCookie(cookieName, val, expire, isHttponly, domain);
            }
        } else {
            setMultiCookie(cookieName, Map2String(cookieMap), expire, isHttponly, domain);
        }

    }

    private static Map<String, String> getHttpCookie(String header) {
        if(StringUtils.isEmpty(header)) {
            return null;
        } else {
            Matcher matcher = COOKIE_PATTERN.matcher(header);
            HashMap cookies = new HashMap();

            while(matcher.find()) {
                cookies.put(matcher.group(1).trim(), matcher.group(2));
            }

            return cookies;
        }
    }

    private static String getHttpCookie(String header, String key) {
        if(StringUtils.isAnyEmpty(new CharSequence[]{header, key})) {
            return null;
        } else {
            Matcher matcher = COOKIE_PATTERN.matcher(header);

            do {
                if(!matcher.find()) {
                    return null;
                }
            } while(!key.equalsIgnoreCase(matcher.group(1).trim()));

            return matcher.group(2);
        }
    }

    private static String getRequestHeadCookie(String key) {
        HttpServletRequest request = HttpContext.getRequest();
        if(request == null) {
            throw new IllegalStateException("none request found from HttpContext.getRequest()");
        } else {
            String header = request.getHeader("cookie");
            return getHttpCookie(header, key);
        }
    }

    private static Map<String, String> getRequestHeadCookie() {
        HttpServletRequest request = HttpContext.getRequest();
        if(request == null) {
            throw new IllegalStateException("none request found from HttpContext.getRequest()");
        } else {
            String header = request.getHeader("cookie");
            return getHttpCookie(header);
        }
    }

    private static String getResponseHeadCookie(String key) {
        HttpServletResponse response = HttpContext.getResponse();
        if(response == null) {
            throw new IllegalStateException("none request found from HttpContext.getResponse()");
        } else {
            String header = response.getHeader("cookie");
            return getHttpCookie(header, key);
        }
    }

    /** @deprecated */
    public static String getResponseCookie(String cookieName, String subKey) {
        String cookieValue = getResponseCookie(cookieName);
        return getValFromString(cookieValue, subKey, true);
    }

    /** @deprecated */
    public static String getResponseCookie(String cookieName) {
        return getResponseHeadCookie(cookieName);
    }

    public static String getCookie(String cookieName, String subKey) {
        String cookieValue = getCookie(cookieName);
        return getValFromString(cookieValue, subKey, true);
    }

    public static String getCookie(String cookieName) {
        if(StringUtils.isEmpty(cookieName)) {
            return null;
        } else {
            String cookieValue = getRequestHeadCookie(cookieName);
            return cleanString(cookieValue);
        }
    }

    public static String[] getCookie(String... names) {
        if(StringUtils.isAnyEmpty(names)) {
            return null;
        } else {
            Map cookies = getRequestHeadCookie();
            if(cookies == null) {
                return null;
            } else {
                String[] vals = new String[names.length];

                for(int i = names.length - 1; i >= 0; --i) {
                    vals[i] = cleanString((String)cookies.get(names[i]));
                }

                return vals;
            }
        }
    }

    private static String cleanString(String content) {
        return content == null?null:XSSDEFENDER.matcher(content).replaceAll("");
    }
}
