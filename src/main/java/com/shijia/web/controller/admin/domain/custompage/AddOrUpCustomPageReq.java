package com.shijia.web.controller.admin.domain.custompage;

/**
 * @author YanxiSir
 * @since 16/12/22
 */
public class AddOrUpCustomPageReq {
    /**
     * 1：add ； 2：update
     */
    private int reqType;

    private int id;
    private String pageNo;
    private String content;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getReqType() {
        return reqType;
    }

    public void setReqType(int reqType) {
        this.reqType = reqType;
    }

    public String getPageNo() {
        return pageNo;
    }

    public void setPageNo(String pageNo) {
        this.pageNo = pageNo;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
