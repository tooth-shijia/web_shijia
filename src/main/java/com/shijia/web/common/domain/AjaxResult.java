package com.shijia.web.common.domain;

/**
 * ajax返回对象
 *
 * @author YanxiSir
 * @since 16/5/21
 */
public class AjaxResult {
    private boolean success;
    private String msg;
    private Object obj;

    public AjaxResult() {
    }

    public AjaxResult(boolean success, String msg) {
        this.msg = msg;
        this.success = success;
        this.obj = null;
    }

    public AjaxResult(boolean success, String msg, Object obj) {
        this.success = success;
        this.msg = msg;
        this.obj = obj;
    }


    public boolean getSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getObj() {
        return obj;
    }

    public void setObj(Object obj) {
        this.obj = obj;
    }
}
