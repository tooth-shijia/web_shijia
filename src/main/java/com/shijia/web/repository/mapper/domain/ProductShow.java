package com.shijia.web.repository.mapper.domain;

import java.util.Date;

/**
 * @author YanxiSir
 * @since 16/5/22
 */
public class ProductShow {

    /**
     * `id` int(10) NOT NULL AUTO_INCREMENT COMMENT 'id 主键',
     * `product_name` varchar(100) NOT NULL DEFAULT '' COMMENT '产品名称',
     * `product_id` varchar(100) NOT NULL DEFAULT '' COMMENT '产品编号',
     * `product_classify` int(10) DEFAULT NULL COMMENT '产品大分类(预留)',
     * `product_type` int(10) DEFAULT NULL COMMENT '产品类型，见表product_type',
     * `comefrom` varchar(50) DEFAULT NULL COMMENT '来源',
     * `author` varchar(50) DEFAULT NULL COMMENT '作者',
     * `content` text DEFAULT NULL COMMENT '产品介绍内容',
     * `show_count` int(5) DEFAULT NULL COMMENT '点击次数',
     * `createtime` datetime DEFAULT NULL COMMENT '创建时间',
     * `lastmodifytime` datetime DEFAULT NULL COMMENT '最后修改时间',
     * `is_delete` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否删除',
     */
    private int id;
    private String productName;
    private String productId;
    private int productClassify;
    private int productType;
    private String comefrom;
    private String author;
    private String content;
    private int showCount;
    private Date createTime;
    private Date lastModifyTime;
    private int isDelete;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public int getProductClassify() {
        return productClassify;
    }

    public void setProductClassify(int productClassify) {
        this.productClassify = productClassify;
    }

    public int getProductType() {
        return productType;
    }

    public void setProductType(int productType) {
        this.productType = productType;
    }

    public String getComefrom() {
        return comefrom;
    }

    public void setComefrom(String comefrom) {
        this.comefrom = comefrom;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getShowCount() {
        return showCount;
    }

    public void setShowCount(int showCount) {
        this.showCount = showCount;
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

    public int getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(int isDelete) {
        this.isDelete = isDelete;
    }
}
