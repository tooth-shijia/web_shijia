package com.shijia.web.common.consts.map;

import com.google.common.collect.ImmutableMap;

import java.util.Map;

/**
 * author: yanxi
 * date : 17/3/12
 */
public class CssClassMapConsts {

    public static Map<Integer, String> shijiaCssClassMap = ImmutableMap.<Integer, String>builder()
            .put(110000, "shijia-1")
            .put(120000, "shijia-2")
            .put(130000, "shijia-3")
            .put(140000, "shijia-4")
            .put(150000, "shijia-5")
            .put(160000, "shijia-6")
            .build();

    public static Map<Integer, String> beiyiCssClassMap = ImmutableMap.<Integer, String>builder()
            .put(210000, "beiyi-1")
            .put(220000, "beiyi-2")
            .put(230000, "beiyi-3")
            .put(240000, "beiyi-4")
            .put(250000, "beiyi-5")
            .build();

    public static Map<Integer, String> newsCssClassMap = ImmutableMap.<Integer, String>builder()
            .put(1, "news-1")
            .put(2, "news-2")
            .build();
}
