package com.shijia.web.common.consts.enums;

/**
 * @author YanxiSir
 * @since 16/12/22
 */
public enum CustomPageEnum {
    GYWM("GYWM"),//关于我们
    CPZS("CPZS"),//产品证书
    QYWH("QYWH"),//企业文化
    SJJJ("SJJJ"),//世佳简介
    JRWM("JRWM"),//加入我们
    LXWM("LXWM"),//联系我们
    GYSJ("GYSJ");//关于世佳


    private String value;

    CustomPageEnum(String value) {
        this.value = value;
    }

    public String value() {
        return this.value;
    }

    public static CustomPageEnum transfer(String name) {
        CustomPageEnum customPageEnum = CustomPageEnum.GYWM;
        for (CustomPageEnum pageEnum : CustomPageEnum.values()) {
            if (pageEnum.value.equalsIgnoreCase(name)) {
                customPageEnum = pageEnum;
                break;
            }
        }
        return customPageEnum;
    }

    public String desc() {
        String desc = "";
        switch (this) {
            case GYWM:
                desc = "关于我们";
                break;
            case CPZS:
                desc = "产品证书";
                break;
            case QYWH:
                desc = "企业文化";
                break;
            case SJJJ:
                desc = "世佳简介";
                break;
            case JRWM:
                desc = "加入我们";
                break;
            case LXWM:
                desc = "联系我们";
                break;
            case GYSJ:
                desc = "关于世佳";
                break;
            default:
                break;
        }
        return desc;
    }
}
