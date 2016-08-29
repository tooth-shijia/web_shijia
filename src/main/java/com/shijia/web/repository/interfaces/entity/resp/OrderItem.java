package com.shijia.web.repository.interfaces.entity.resp;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.Date;
import java.util.List;

/**
 * @author YanxiSir
 * @since 16/8/25
 */
public class OrderItem {

    /**
     * 订单类型
     */
    private String order_type;

    /**
     * 订单编号
     */
    private String order_no;

    /**
     * 客户编号
     */
    private String customer_no;

    /**
     * 客户名称
     */
    private String customer_name;

    /**
     * 医生姓名
     */
    private String dr_name;

    /**
     * 患者姓名
     */
    private String pt_name;

    /**
     * 盒号
     */
    private String box_no;

    /**
     * 入件日期
     */
    private String input_date;

    /**
     * 预出货日期
     */
    private String due_date;

    /**
     * 打印日期
     */
    private String print_date;

    /**
     * 是否出货
     */
    private int finished_unfinished;

    /**
     * 审核
     */
    private int audit;

    /**
     * 医嘱
     */
    private String instruction;

    /**
     * 附件
     */
    private String attachement;

    /**
     * 加急
     */
    private int rush_case;

    /**
     * 内部备注
     */
    private String lab_note;

    /**
     * 回单
     */
    private String confirmation_letter;

    /**
     * 当前工序
     */
    private String exist_status;

    /**
     * 外发单位
     */
    private String outsource_name;

    /**
     * 照片
     */
    private String picture;

    /**
     * 快递单号
     */
    private String tracking_no;

    private List<XmData> xmData;


    public String getOrder_type() {
        return order_type;
    }

    @JSONField(name = "ORDER_TYPE")
    public void setOrder_type(String order_type) {
        this.order_type = order_type;
    }

    public String getOrder_no() {
        return order_no;
    }

    @JSONField(name = "ORDER_NO")
    public void setOrder_no(String order_no) {
        this.order_no = order_no;
    }

    public String getCustomer_no() {
        return customer_no;
    }

    @JSONField(name = "CUSTOMER_NO")
    public void setCustomer_no(String customer_no) {
        this.customer_no = customer_no;
    }

    public String getCustomer_name() {
        return customer_name;
    }

    @JSONField(name = "CUSTOMER_NAME")
    public void setCustomer_name(String customer_name) {
        this.customer_name = customer_name;
    }

    public String getDr_name() {
        return dr_name;
    }

    @JSONField(name = "DR_NAME")
    public void setDr_name(String dr_name) {
        this.dr_name = dr_name;
    }

    public String getPt_name() {
        return pt_name;
    }

    @JSONField(name = "PT_NAME")
    public void setPt_name(String pt_name) {
        this.pt_name = pt_name;
    }

    public String getBox_no() {
        return box_no;
    }

    @JSONField(name = "BOX_NO")
    public void setBox_no(String box_no) {
        this.box_no = box_no;
    }

    public String getInput_date() {
        return input_date;
    }

    @JSONField(name = "INPUT_DATE")
    public void setInput_date(String input_date) {
        this.input_date = input_date;
    }

    public String getDue_date() {
        return due_date;
    }

    @JSONField(name = "DUE_DATE")
    public void setDue_date(String due_date) {
        this.due_date = due_date;
    }

    public String getPrint_date() {
        return print_date;
    }

    @JSONField(name = "PRINT_DATE")
    public void setPrint_date(String print_date) {
        this.print_date = print_date;
    }

    public int getFinished_unfinished() {
        return finished_unfinished;
    }

    @JSONField(name = "FINISHED_UNFINISHED")
    public void setFinished_unfinished(int finished_unfinished) {
        this.finished_unfinished = finished_unfinished;
    }

    public int getAudit() {
        return audit;
    }

    @JSONField(name = "AUDIT")
    public void setAudit(int audit) {
        this.audit = audit;
    }

    public String getInstruction() {
        return instruction;
    }

    @JSONField(name = "INSTRUCTION")
    public void setInstruction(String instruction) {
        this.instruction = instruction;
    }

    public String getAttachement() {
        return attachement;
    }

    @JSONField(name = "ATTACHMENT")
    public void setAttachement(String attachement) {
        this.attachement = attachement;
    }

    public int getRush_case() {
        return rush_case;
    }

    @JSONField(name = "RUSH_CASE")
    public void setRush_case(int rush_case) {
        this.rush_case = rush_case;
    }

    public String getLab_note() {
        return lab_note;
    }

    @JSONField(name = "LAB_NOTE")
    public void setLab_note(String lab_note) {
        this.lab_note = lab_note;
    }

    public String getConfirmation_letter() {
        return confirmation_letter;
    }

    @JSONField(name = "CONFIRMATION_LETTER")
    public void setConfirmation_letter(String confirmation_letter) {
        this.confirmation_letter = confirmation_letter;
    }

    public String getExist_status() {
        return exist_status;
    }

    @JSONField(name = "EXIST_STATUS")
    public void setExist_status(String exist_status) {
        this.exist_status = exist_status;
    }

    public String getOutsource_name() {
        return outsource_name;
    }

    @JSONField(name = "OUTSOURCE_NAME")
    public void setOutsource_name(String outsource_name) {
        this.outsource_name = outsource_name;
    }

    public String getPicture() {
        return picture;
    }

    @JSONField(name = "PICTURE")
    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getTracking_no() {
        return tracking_no;
    }

    @JSONField(name = "TRACKING_NO")
    public void setTracking_no(String tracking_no) {
        this.tracking_no = tracking_no;
    }

    public List<XmData> getXmData() {
        return xmData;
    }

    @JSONField(name = "XMDATA")
    public void setXmData(List<XmData> xmData) {
        this.xmData = xmData;
    }
}
