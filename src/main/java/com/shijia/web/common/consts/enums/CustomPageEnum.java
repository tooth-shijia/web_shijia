package com.shijia.web.common.consts.enums;

/**
 * @author YanxiSir
 * @since 16/12/22
 */
public enum CustomPageEnum {

    GYWM("GYWM");//关于我们


    private String value;

    CustomPageEnum(String value) {
        this.value = value;
    }

    private String value() {
        return this.value;
    }
}
