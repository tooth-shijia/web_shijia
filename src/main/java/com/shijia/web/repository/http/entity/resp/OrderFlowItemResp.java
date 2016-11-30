package com.shijia.web.repository.http.entity.resp;

import java.util.List;

/**
 * @author YanxiSir
 * @since 16/8/29
 */
public class OrderFlowItemResp {

    /**
     * 4002：参数订单编号为空
     * 4001：无数据返回
     */
    private int code;
    /**
     * 代码说明
     */
    private String explain;
    /**
     * 记录总数
     */
    private int records;

    private List<OrderFlowItem> data;

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

    public List<OrderFlowItem> getData() {
        return data;
    }

    public void setData(List<OrderFlowItem> data) {
        this.data = data;
    }
}
