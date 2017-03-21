package com.shijia.web.repository.mapper.domain;

import java.util.Date;

/**
 * @author YanxiSir
 * @since 16/5/22
 */
public class NewsShow {
    /**
     * `id` int(10) NOT NULL AUTO_INCREMENT COMMENT 'id 主键',
     * `news_name` varchar(100) NOT NULL DEFAULT '' COMMENT '新闻名称',
     * `news_type` int(3) NOT NULL DEFAULT '' COMMENT '新闻类型，1：公司新闻；2，行业新闻；3，口腔百科',
     * `comefrom` varchar(50) DEFAULT NULL COMMENT '来源',
     * `author` varchar(50) DEFAULT NULL COMMENT '作者',
     * `content` text DEFAULT NULL COMMENT '新闻内容',
     * `show_count` int(5) DEFAULT NULL COMMENT '点击次数',
     * `createtime` datetime DEFAULT NULL COMMENT '创建时间',
     * `lastmodifytime` datetime DEFAULT NULL COMMENT '最后修改时间',
     * `is_delete` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否删除',
     * `cover_image` varchar(100) default '' comment '产品封面'
     */
    private int id;
    private String newsName;
    private int newsType;
    private String comefrom;
    private String author;
    private String content;
    private int showCount;
    private Date createTime;
    private Date lastModifyTime;
    private int isDelete;

    private String coverImage;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNewsName() {
        return newsName;
    }

    public void setNewsName(String newsName) {
        this.newsName = newsName;
    }

    public int getNewsType() {
        return newsType;
    }

    public void setNewsType(int newsType) {
        this.newsType = newsType;
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

    public String getCoverImage() {
        return coverImage;
    }

    public void setCoverImage(String coverImage) {
        this.coverImage = coverImage;
    }
}
