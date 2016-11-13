package com.shijia.web.controller.admin.viewmodel.product;


/**
 * @author YanxiSir
 * @since 16/11/13
 */
public class ProductTypeModel {

    private int id;

    private int typeId;
    private String typeName;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
}
