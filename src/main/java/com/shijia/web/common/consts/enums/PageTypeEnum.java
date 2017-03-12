package com.shijia.web.common.consts.enums;

/**
 * author: yanxi
 * date : 17/3/12
 */
public enum PageTypeEnum {

    PRODUCT_SHIJIA(1),
    PRODUCT_BEIYI(2),
    NEWS(3);


    private int _i;

    PageTypeEnum(int i) {
        this._i = i;
    }

    public int value() {
        return this._i;
    }
}
