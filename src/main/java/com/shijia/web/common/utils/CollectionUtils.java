package com.shijia.web.common.utils;

import java.util.Collection;

/**
 * @author YanxiSir
 * @since 16/12/25
 */
public class CollectionUtils {

    public static boolean isEmpty(Collection collection) {
        if (collection == null || collection.isEmpty()) {
            return true;
        }
        return false;
    }

    public static boolean isNotEmpty(Collection collection) {
        return !isEmpty(collection);
    }
}
