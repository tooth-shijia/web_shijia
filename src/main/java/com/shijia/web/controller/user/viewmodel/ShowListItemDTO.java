package com.shijia.web.controller.user.viewmodel;

/**
 * @author YanxiSir
 * @since 17/3/19
 */
public class ShowListItemDTO {
    private int id;
    private String name;
    private String comefrom;
    private String className;
    private int typeId;
    /**
     * productId或newsId
     */
    private String bodyId;
    private String url;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getComefrom() {
        return comefrom;
    }

    public void setComefrom(String comefrom) {
        this.comefrom = comefrom;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }

    public String getBodyId() {
        return bodyId;
    }

    public void setBodyId(String bodyId) {
        this.bodyId = bodyId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
