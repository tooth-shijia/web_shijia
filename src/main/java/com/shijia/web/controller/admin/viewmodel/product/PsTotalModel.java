package com.shijia.web.controller.admin.viewmodel.product;

/**
 * @author YanxiSir
 * @since 16/11/13
 */
public class PsTotalModel {

    /**
     * 总数
     */
    private int total;
    /**
     * 分页数
     */
    private int pageSize;

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
}
