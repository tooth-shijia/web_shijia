package com.shijia.web.repository.mapper.domain;

import java.util.Date;

/**
 * @author YanxiSir
 * @since 16/12/22
 */
public class CustomPageTypeDO {


    private int id;
    private String pageNo;
    private String pageName;
    private Date createTime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPageNo() {
        return pageNo;
    }

    public void setPageNo(String pageNo) {
        this.pageNo = pageNo;
    }

    public String getPageName() {
        return pageName;
    }

    public void setPageName(String pageName) {
        this.pageName = pageName;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
