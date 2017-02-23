package com.shijia.web.controller.user.viewmodel;

import java.util.List;

/**
 * @author YanxiSir
 * @since 17/2/23
 */
public class ShowListPageDTO {

    private String title;
    private String desc;
    private List<TypeItemVM> typeItemVMList;
    private int typeSize;


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public List<TypeItemVM> getTypeItemVMList() {
        return typeItemVMList;
    }

    public void setTypeItemVMList(List<TypeItemVM> typeItemVMList) {
        this.typeItemVMList = typeItemVMList;
    }

    public int getTypeSize() {
        return typeSize;
    }

    public void setTypeSize(int typeSize) {
        this.typeSize = typeSize;
    }

    public static class TypeItemVM {
        private int id;
        private String name;

        public TypeItemVM() {
        }

        public TypeItemVM(int id, String name) {
            this.id = id;
            this.name = name;
        }

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
    }
}
