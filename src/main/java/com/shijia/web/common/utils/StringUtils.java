package com.shijia.web.common.utils;


import org.apache.commons.lang3.ArrayUtils;

/**
 * Created by lianfang.tan on 16/3/8.
 */
public class StringUtils {

    public static boolean isEmpty(String content) {
        return content == null || content.trim().length() == 0;

    }

    public static boolean isNotEmpty(String content) {
        return !isEmpty(content);
    }

    public static boolean isEmpty(CharSequence cs){
        return cs == null || cs.toString().trim().length() == 0;
    }

    public static boolean isAnyEmpty(CharSequence... css) {
        if (ArrayUtils.isEmpty(css)) {
            return true;
        } else {
            CharSequence[] arr$ = css;
            int len$ = css.length;

            for (int i$ = 0; i$ < len$; ++i$) {
                CharSequence cs = arr$[i$];
                if (isEmpty(cs)) {
                    return true;
                }
            }

            return false;
        }
    }

}
