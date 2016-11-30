package com.shijia.web.repository.http.entity.resp;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * @author YanxiSir
 * @since 16/8/25
 */
public class XmData {

    /**
     * 产品id
     */
    private String product_id;

    /**
     * 产品名称
     */
    private String product_name;

    private String a;

    private String b;

    private String c;

    private String d;

    /**
     * 种植数
     */
    private int implant_no;

    /**
     * 颜色
     */
    private String shade;

    /**
     * 数量
     */
    private int quantity;

    /**
     * 状态
     */
    private String status;

    /**
     * 产品备注
     */
    private String product_note;

    /**
     * 收费方式
     */
    private String payment_terms;

    /**
     * 单价
     */
    private double price;

    /**
     * 总金额
     */
    private double total_amount;


    public String getProduct_id() {
        return product_id;
    }

    @JSONField(name = "PRODUCT_ID")
    public void setProduct_id(String product_id) {
        this.product_id = product_id;
    }

    public String getProduct_name() {
        return product_name;
    }

    @JSONField(name = "PRODUCT_NAME")
    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public String getA() {
        return a;
    }

    @JSONField(name = "A")
    public void setA(String a) {
        this.a = a;
    }

    public String getB() {
        return b;
    }

    @JSONField(name = "B")
    public void setB(String b) {
        this.b = b;
    }

    public String getC() {
        return c;
    }

    @JSONField(name = "C")
    public void setC(String c) {
        this.c = c;
    }

    public String getD() {
        return d;
    }

    @JSONField(name = "D")
    public void setD(String d) {
        this.d = d;
    }

    public int getImplant_no() {
        return implant_no;
    }

    @JSONField(name = "IMPLANT_NO")
    public void setImplant_no(int implant_no) {
        this.implant_no = implant_no;
    }

    public String getShade() {
        return shade;
    }

    @JSONField(name = "SHADE")
    public void setShade(String shade) {
        this.shade = shade;
    }

    public int getQuantity() {
        return quantity;
    }

    @JSONField(name = "QUANTITY")
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getStatus() {
        return status;
    }

    @JSONField(name = "STATUS")
    public void setStatus(String status) {
        this.status = status;
    }

    public String getProduct_note() {
        return product_note;
    }

    @JSONField(name = "PRODUCT_NOTE")
    public void setProduct_note(String product_note) {
        this.product_note = product_note;
    }

    public String getPayment_terms() {
        return payment_terms;
    }

    @JSONField(name = "PAYMENT_TERMS")
    public void setPayment_terms(String payment_terms) {
        this.payment_terms = payment_terms;
    }

    public double getPrice() {
        return price;
    }

    @JSONField(name = "PRICE")
    public void setPrice(double price) {
        this.price = price;
    }

    public double getTotal_amount() {
        return total_amount;
    }

    @JSONField(name = "TOTAL_AMOUNT")
    public void setTotal_amount(double total_amount) {
        this.total_amount = total_amount;
    }
}
