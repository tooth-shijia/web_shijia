package com.shijia.web.common.consts.enums;

/**
 * @author YanxiSir
 * @since 16/12/22
 */
public enum CustomPageStatusEnum {
    DEL(-1), //删除
    USING(1), //启用
    NOT_USING(2); //不启用

    private int _i;

    CustomPageStatusEnum(int _i) {
        this._i = _i;
    }

    public int value() {
        return this._i;
    }
}

