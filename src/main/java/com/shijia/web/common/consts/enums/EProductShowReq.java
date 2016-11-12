package com.shijia.web.common.consts.enums;

/**
 * @author YanxiSir
 * @since 16/11/13
 */
public enum EProductShowReq {

    REQ_ADD(1),
    REQ_UPDATE(2);

    private int _i;

    EProductShowReq(int i) {
        this._i = i;
    }

    public int value() {
        return this._i;
    }
}
