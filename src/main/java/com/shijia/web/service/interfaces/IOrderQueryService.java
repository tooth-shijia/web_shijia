package com.shijia.web.service.interfaces;

import com.shijia.web.repository.interfaces.entity.resp.OrderFlowItemResp;
import com.shijia.web.repository.interfaces.entity.resp.OrderQueryItemResp;

import java.util.List;

/**
 * @author YanxiSir
 * @since 16/8/25
 */
public interface IOrderQueryService {

    /**
     * 订单详情查询
     *
     * @param str      要查询的内容
     * @param tag      查询字段（1-订单号 ； 2-患者姓名）
     * @param accurate 是否精确查找（1-精确 ； 2-模糊）
     * @return
     * @throws Exception
     */
    public List<OrderQueryItemResp> queryOrderDetail(String str, int tag, int accurate);

    /**
     * 订单流程记录查询
     *
     * @param orderid 订单号
     * @return
     * @throws Exception
     */
    public List<OrderFlowItemResp> queryOrderFlow(String orderid);
}
