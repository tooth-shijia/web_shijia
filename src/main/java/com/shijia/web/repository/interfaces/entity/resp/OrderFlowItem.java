package com.shijia.web.repository.interfaces.entity.resp;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * @author YanxiSir
 * @since 16/8/29
 */
public class OrderFlowItem {

    /**
     * 订单编号
     */
    @JSONField(name = "ORDER_ON")
    private String order_no;

    /**
     * 时间
     */
    @JSONField(name = "INPUT_TIME")
    private String input_time;

    /**
     * 工序名称
     */
    @JSONField(name = "PROCESS_NAME")
    private String process_name;

    /**
     * 操作人员
     */
    @JSONField(name = "USER_NAME")
    private String user_name;

    /**
     * 部门（如果工序名称为原材料批号那里面的值就是材料批号）
     */
    @JSONField(name = "DEPARTMENT_NAEM")
    private String department_name;

    /**
     * 参数（一些附加值，用于调用其它模块的可以不用理会）
     */
    @JSONField(name = "PARAMETER")
    private String parameter;

    /**
     * 备注
     */
    @JSONField(name = "REMARKS")
    private String remarks;

    public String getOrder_no() {
        return order_no;
    }

    public void setOrder_no(String order_no) {
        this.order_no = order_no;
    }

    public String getInput_time() {
        return input_time;
    }

    public void setInput_time(String input_time) {
        this.input_time = input_time;
    }

    public String getProcess_name() {
        return process_name;
    }

    public void setProcess_name(String process_name) {
        this.process_name = process_name;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getDepartment_name() {
        return department_name;
    }

    public void setDepartment_name(String department_name) {
        this.department_name = department_name;
    }

    public String getParameter() {
        return parameter;
    }

    public void setParameter(String parameter) {
        this.parameter = parameter;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}
