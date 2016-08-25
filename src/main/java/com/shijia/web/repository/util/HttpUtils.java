package com.shijia.web.repository.util;

import com.alibaba.fastjson.JSON;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.CoreConnectionPNames;
import org.apache.http.util.EntityUtils;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

/**
 * @author YanxiSir
 * @since 16/8/25
 */
public class HttpUtils {

    /**
     * get请求
     *
     * @param urlStr
     * @param timeout
     * @param clazz
     * @param <T>
     * @return
     * @throws Exception
     */
    public static <T> T get(String urlStr, int timeout, Class<T> clazz) throws Exception {
        StringBuilder str = new StringBuilder("");
        URL url = new URL(urlStr);
        // 打开URL链接
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        // 以GET方式传送接口参数
        conn.setDoOutput(true);
        conn.setDoInput(true);
        conn.setReadTimeout(timeout);//?
        conn.setRequestMethod("GET");
        // 获取接口响应信息
        BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));

        String line;
        while (null != (line = br.readLine()))
            str.append(line);
        br.close();
        String result = str.toString();
        if (StringUtils.isNotBlank(result)) {
            return JSON.parseObject(result, clazz);
        }
        return null;
    }

    /**
     * post请求
     *
     * @param urlStr
     * @param timeout
     * @param params
     * @param clazz
     * @param <T>
     * @return
     * @throws Exception
     */
    public static <T> T post(String urlStr, int timeout, List<NameValuePair> params, Class<T> clazz) throws Exception {
        HttpClient client = new DefaultHttpClient();
        HttpPost post = new HttpPost(urlStr);
        client.getParams().setParameter(CoreConnectionPNames.SO_TIMEOUT, timeout);
        post.setEntity(new UrlEncodedFormEntity(params, "utf-8"));
        HttpResponse response = client.execute(post);
        HttpEntity respEntity = response.getEntity();
        String result = EntityUtils.toString(respEntity, "utf-8");
        if (StringUtils.isNotBlank(result)) {
            return JSON.parseObject(result, clazz);
        }
        return null;
    }
}
