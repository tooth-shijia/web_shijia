package com.shijia.web.common.framework.ajax;

import java.io.Serializable;

public class AjaxResult implements Serializable {

	private static final long serialVersionUID = 1L;

	private boolean success;
	private String msg;
	private Object data;

	public AjaxResult(boolean isSuccess) {
		super();
		this.success = isSuccess;
	}

	public AjaxResult(boolean isSuccess, Object data) {
		super();
		this.success = isSuccess;
		this.data = data;
	}

	public AjaxResult(boolean isSuccess, String msg, Object data) {
		super();
		this.success = isSuccess;
		this.msg = msg;
		this.data = data;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean isSuccess) {
		this.success = isSuccess;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

}
