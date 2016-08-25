package com.shijia.web.repository.interfaces.entity.resp;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * @author YanxiSir
 * @since 16/8/25
 */
public class XmData {

    /**
     * 产品id
     */
    @JSONField(name = "PRODUCT_ID")
    private String product_id;

    /**
     * 产品名称
     */
    @JSONField(name = "PRODUCT_NAME")
    private String product_name;

    @JSONField(name = "A")
    private String a;

    @JSONField(name = "B")
    private String b;

    @JSONField(name = "C")
    private String c;

    @JSONField(name = "D")
    private String d;

    /**
     * 种植数
     */
    @JSONField(name = "IMPLANT_NO")
    private int implant_no;

    /**
     * 颜色
     */
    @JSONField(name = "SHADE")
    private String shade;

    /**
     * 数量
     */
    @JSONField(name = "QUANTITY")
    private int quantity;

    /**
     * 状态
     */
    @JSONField(name = "STATUS")
    private String status;

    /**
     * 产品备注
     */
    @JSONField(name = "PRODUCT_NOTE")
    private String product_note;

    /**
     * 收费方式
     */
    @JSONField(name = "PAYMENT_TERMS")
    private String payment_terms;

    /**
     * 单价
     */
    @JSONField(name = "PRICE")
    private double price;

    /**
     * 总金额
     */
    @JSONField(name = "TOTAL_AMOUNT")
    private double total_amount;


    public String getProduct_id() {
        return product_id;
    }

    public void setProduct_id(String product_id) {
        this.product_id = product_id;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public String getA() {
        return a;
    }

    public void setA(String a) {
        this.a = a;
    }

    public String getB() {
        return b;
    }

    public void setB(String b) {
        this.b = b;
    }

    public String getC() {
        return c;
    }

    public void setC(String c) {
        this.c = c;
    }

    public String getD() {
        return d;
    }

    public void setD(String d) {
        this.d = d;
    }

    public int getImplant_no() {
        return implant_no;
    }

    public void setImplant_no(int implant_no) {
        this.implant_no = implant_no;
    }

    public String getShade() {
        return shade;
    }

    public void setShade(String shade) {
        this.shade = shade;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getProduct_note() {
        return product_note;
    }

    public void setProduct_note(String product_note) {
        this.product_note = product_note;
    }

    public String getPayment_terms() {
        return payment_terms;
    }

    public void setPayment_terms(String payment_terms) {
        this.payment_terms = payment_terms;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getTotal_amount() {
        return total_amount;
    }

    public void setTotal_amount(double total_amount) {
        this.total_amount = total_amount;
    }
}
