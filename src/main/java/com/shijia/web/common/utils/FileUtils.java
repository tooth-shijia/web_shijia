package com.shijia.web.common.utils;

import java.io.File;
import java.io.IOException;

/**
 * @author YanxiSir
 * @since 17/3/21
 */
public class FileUtils {

    public static File getFile(String path, String name) throws IOException {
        File file = new File(path);
        if (!file.exists()) {
            file.mkdirs();
        }
        File file1 = new File(path + name);
        if (!file1.exists() && !file1.isDirectory()) {
            file1.createNewFile();
        }
        return file1;
    }
}
