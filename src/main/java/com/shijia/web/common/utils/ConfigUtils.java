package com.shijia.web.common.utils;

import java.io.*;
import java.net.URI;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

/**
 * @author YanxiSir
 * @since 16/5/21
 */
public class ConfigUtils {

    private static Properties WebProperties;

    /**
     * 获取properties
     */
    public static Properties getProperties(String fileName) throws FileNotFoundException, IOException {
        if (fileName == null || fileName.trim().length() == 0) {
            return null;
        }
        Properties p = new Properties();
        InputStream is = null;
        BufferedReader bf = null;
        try {
            is = new BufferedInputStream(new FileInputStream(fileName));
            bf = new BufferedReader(new InputStreamReader(is));
            p.load(bf);
        } catch (FileNotFoundException e) {
            throw e;
        } catch (IOException e) {
            throw e;
        } finally {
            if (is != null) {
                is.close();
            }
            if (bf != null) {
                bf.close();
            }
        }
        return p;
    }

    /**
     * 获取webproperties
     */
    public static Properties getWebProperties() throws FileNotFoundException, IOException {
        String path = getCurrentPath("config", "config/web.properties");
        return getProperties(path);
    }

    /**
     * 获取web.properties中的某个属性值
     */
    public static String getWebPropertiesAttr(String key) throws FileNotFoundException, IOException {
        if (key == null || key.trim().length() == 0)
            return "";
        if (WebProperties == null)
            WebProperties = getWebProperties();
        if (WebProperties == null || !WebProperties.containsKey(key.toString()))
            return "";
        return WebProperties.getProperty(key.toString());
    }


    /**
     * 获取指定文件路径
     */
    public static String getCurrentPath(String... path) {
        URL url = Thread.currentThread().getContextClassLoader().getResource("");
        Path p = Paths.get(URI.create(url.toString()));
        return Paths.get(p.toString(), path).toString();
    }

}
