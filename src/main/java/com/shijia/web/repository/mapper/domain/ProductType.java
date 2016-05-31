package com.shijia.web.repository.mapper.domain;

import java.util.Date;

/**
 * @author YanxiSir
 * @since 16/5/22
 */
public class ProductType {
    /**
     * 'id' int(10) NOT NULL AUTO_INCREMENT COMMENT 'id 主键',
     * 'type_name' varchar(50) NOT NULL DEFAULT '' COMMENT '类型名',
     * 'createtime' datatime DEFAULT NULL COMMENT '添加时间',
     * 'lastmodifytime' datetime DEFAULT NULL COMMENT '最后修改时间',
     * 'lastmodifypeople' varchar(50) NOT NULL DEFAULT '' COMMENT '最后修改人',
     */
    private int id;
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
