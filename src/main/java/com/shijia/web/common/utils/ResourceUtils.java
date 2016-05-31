package com.shijia.web.common.utils;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URI;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

/**
 * @author YanxiSir
 * @since 16/3/27.
 */
public class ResourceUtils {

    static Properties webProperties = null;

    public static String getWebPropertiesAttr(String key) throws Exception {
        if (key == null || key.trim().length() == 0) {
            return "";
        }
        if (webProperties == null)
            webProperties = getWebProperties();
        if (webProperties == null || !webProperties.containsKey(key))
            return "";
        return webProperties.getProperty(key);

    }

    public static Properties getWebProperties() throws Exception {
        String path = getCurrentPath("config", "web.properties");
        return getProperties(path);
    }

    public static Properties getProperties(String fileName) throws Exception {
        if (fileName == null || fileName.trim().length() <= 0) {
            return null;
        }
        Properties p = new Properties();
        InputStream is = null;
        is = new BufferedInputStream(new FileInputStream(fileName));
        p.load(is);
        is.close();
        return p;
    }

    public static String getCurrentPath(String... path) {
        URL url = Thread.currentThread().getContextClassLoader().getResource("");
        Path p = Paths.get(URI.create(url.toString()));
        return Paths.get(p.toString(), path).toString();
    }
}
