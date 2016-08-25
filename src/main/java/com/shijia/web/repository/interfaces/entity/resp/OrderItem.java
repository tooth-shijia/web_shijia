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
    @JSONField(name = "ORDER_TYPE")
    private String order_type;

    /**
     * 订单编号
     */
    @JSONField(name = "ORDER_NO")
    private String order_no;

    /**
     * 客户编号
     */
    @JSONField(name = "CUSTOMER_NO")
    private String customer_no;

    /**
     * 客户名称
     */
    @JSONField(name = "CUSTOMER_NAME")
    private String customer_name;

    /**
     * 医生姓名
     */
    @JSONField(name = "DR_NAME")
    private String dr_name;

    /**
     * 患者姓名
     */
    @JSONField(name = "PT_NAME")
    private String pt_name;

    /**
     * 盒号
     */
    @JSONField(name = "BOX_NO")
    private String box_no;

    /**
     * 入件日期
     */
    @JSONField(name = "INPUT_DATE")
    private Date input_date;

    /**
     * 预出货日期
     */
    @JSONField(name = "DUE_DATE")
    private Date due_date;

    /**
     * 打印日期
     */
    @JSONField(name = "PRINT_DATE")
    private Date print_date;

    /**
     * 是否出货
     */
    @JSONField(name = "FINISHED_UNFINISHED")
    private int finished_unfinished;

    /**
     * 审核
     */
    @JSONField(name = "AUDIT")
    private int audit;

    /**
     * 医嘱
     */
    @JSONField(name = "INSTRUCTION")
    private String instruction;

    /**
     * 附件
     */
    @JSONField(name = "ATTACHMENT")
    private String attachement;

    /**
     * 加急
     */
    @JSONField(name = "RUSH_CASE")
    private int rush_case;

    /**
     * 内部备注
     */
    @JSONField(name = "LAB_NOTE")
    private String lab_note;

    /**
     * 回单
     */
    @JSONField(name = "CONFIRMATION_LETTER")
    private String confirmation_letter;

    /**
     * 当前工序
     */
    @JSONField(name = "EXIST_STATUS")
    private String exist_status;

    /**
     * 外发单位
     */
    @JSONField(name = "OUTSOURCE_NAME")
    private String outsource_name;

    /**
     * 照片
     */
    @JSONField(name = "PICTURE")
    private String picture;

    /**
     * 快递单号
     */
    @JSONField(name = "TRACKING_NO")
    private String tracking_no;

    @JSONField(name = "XMDATA")
    private List<XmData> xmData;


    public String getOrder_type() {
        return order_type;
    }

    public void setOrder_type(String order_type) {
        this.order_type = order_type;
    }

    public String getOrder_no() {
        return order_no;
    }

    public void setOrder_no(String order_no) {
        this.order_no = order_no;
    }

    public String getCustomer_no() {
        return customer_no;
    }

    public void setCustomer_no(String customer_no) {
        this.customer_no = customer_no;
    }

    public String getCustomer_name() {
        return customer_name;
    }

    public void setCustomer_name(String customer_name) {
        this.customer_name = customer_name;
    }

    public String getDr_name() {
        return dr_name;
    }

    public void setDr_name(String dr_name) {
        this.dr_name = dr_name;
    }

    public String getPt_name() {
        return pt_name;
    }

    public void setPt_name(String pt_name) {
        this.pt_name = pt_name;
    }

    public String getBox_no() {
        return box_no;
    }

    public void setBox_no(String box_no) {
        this.box_no = box_no;
    }

    public Date getInput_date() {
        return input_date;
    }

    public void setInput_date(Date input_date) {
        this.input_date = input_date;
    }

    public Date getDue_date() {
        return due_date;
    }

    public void setDue_date(Date due_date) {
        this.due_date = due_date;
    }

    public Date getPrint_date() {
        return print_date;
    }

    public void setPrint_date(Date print_date) {
        this.print_date = print_date;
    }

    public int getFinished_unfinished() {
        return finished_unfinished;
    }

    public void setFinished_unfinished(int finished_unfinished) {
        this.finished_unfinished = finished_unfinished;
    }

    public int getAudit() {
        return audit;
    }

    public void setAudit(int audit) {
        this.audit = audit;
    }

    public String getInstruction() {
        return instruction;
    }

    public void setInstruction(String instruction) {
        this.instruction = instruction;
    }

    public String getAttachement() {
        return attachement;
    }

    public void setAttachement(String attachement) {
        this.attachement = attachement;
    }

    public int getRush_case() {
        return rush_case;
    }

    public void setRush_case(int rush_case) {
        this.rush_case = rush_case;
    }

    public String getLab_note() {
        return lab_note;
    }

    public void setLab_note(String lab_note) {
        this.lab_note = lab_note;
    }

    public String getConfirmation_letter() {
        return confirmation_letter;
    }

    public void setConfirmation_letter(String confirmation_letter) {
        this.confirmation_letter = confirmation_letter;
    }

    public String getExist_status() {
        return exist_status;
    }

    public void setExist_status(String exist_status) {
        this.exist_status = exist_status;
    }

    public String getOutsource_name() {
        return outsource_name;
    }

    public void setOutsource_name(String outsource_name) {
        this.outsource_name = outsource_name;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getTracking_no() {
        return tracking_no;
    }

    public void setTracking_no(String tracking_no) {
        this.tracking_no = tracking_no;
    }

    public List<XmData> getXmData() {
        return xmData;
    }

    public void setXmData(List<XmData> xmData) {
        this.xmData = xmData;
    }
}
