package com.shijia.web.common.consts.enums;

/**
 * @author YanxiSir
 * @since 16/11/13
 */
public enum ESiteType {

    SITE_SHIJIA(1),

    SITE_BEIYI(2);

    private int _i;

    ESiteType(int i) {
        this._i = i;
    }

    public int value() {
        return this._i;
    }
}
