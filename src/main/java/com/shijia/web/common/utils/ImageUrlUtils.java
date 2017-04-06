package com.shijia.web.common.utils;

import java.text.MessageFormat;

/**
 * @author YanxiSir
 * @since 17/4/6
 */
public class ImageUrlUtils {

    private static final String PRODUCT_COVER = "/web/image/product/show/{0}";
    private static final String NEWS_COVER = "/web/image/news/show/{0}";

    public static String productCover(String name) {
        return MessageFormat.format(PRODUCT_COVER, name);
    }

    public static String newsCover(String name) {
        return MessageFormat.format(NEWS_COVER, name);
    }
}
