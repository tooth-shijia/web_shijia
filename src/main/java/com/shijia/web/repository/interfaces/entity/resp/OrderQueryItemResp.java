package com.shijia.web.repository.interfaces.entity.resp;

import java.util.List;

/**
 * 查询订单，每一项resp
 *
 * @author YanxiSir
 * @since 16/8/25
 */
public class OrderQueryItemResp {

    private int code;
    private String explain;
    private int records;
    private int ordernumber;

    private List<OrderItem> data;


    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getExplain() {
        return explain;
    }

    public void setExplain(String explain) {
        this.explain = explain;
    }

    public int getRecords() {
        return records;
    }

    public void setRecords(int records) {
        this.records = records;
    }

    public int getOrdernumber() {
        return ordernumber;
    }

    public void setOrdernumber(int ordernumber) {
        this.ordernumber = ordernumber;
    }

    public List<OrderItem> getData() {
        return data;
    }

    public void setData(List<OrderItem> data) {
        this.data = data;
    }
}
