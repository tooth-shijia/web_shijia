package com.shijia.web.repository.mapper.domain;

import java.util.Date;

/**
 * @author YanxiSir
 * @since 16/5/22
 */
public class ProductType {

    private int id;
    private int siteId;
    private int parentTypeId;
    private String parentTypeName;
    private int typeId;
    private String typeName;
    private Date createTime;
    private Date lastModifyTime;
    private String lastModifyPeople;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSiteId() {
        return siteId;
    }

    public void setSiteId(int siteId) {
        this.siteId = siteId;
    }

    public int getParentTypeId() {
        return parentTypeId;
    }

    public void setParentTypeId(int parentTypeId) {
        this.parentTypeId = parentTypeId;
    }

    public String getParentTypeName() {
        return parentTypeName;
    }

    public void setParentTypeName(String parentTypeName) {
        this.parentTypeName = parentTypeName;
    }

    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getLastModifyTime() {
        return lastModifyTime;
    }

    public void setLastModifyTime(Date lastModifyTime) {
        this.lastModifyTime = lastModifyTime;
    }

    public String getLastModifyPeople() {
        return lastModifyPeople;
    }

    public void setLastModifyPeople(String lastModifyPeople) {
        this.lastModifyPeople = lastModifyPeople;
    }
}
