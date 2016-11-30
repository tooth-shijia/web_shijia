package com.shijia.web.service;

import com.shijia.web.common.utils.LogHelper;
import com.shijia.web.repository.http.OrderQueryHttp;
import com.shijia.web.repository.http.entity.resp.OrderFlowItemResp;
import com.shijia.web.repository.http.entity.resp.OrderQueryItemResp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author YanxiSir
 * @since 16/8/25
 */
@Service
public class OrderQueryService  {

    @Autowired
    private OrderQueryHttp orderQueryHttp;

    public List<OrderQueryItemResp> queryOrderDetail(String str, int tag, int accurate) {

        try {
            return orderQueryHttp.queryOrderDetail(str, tag, accurate);
        } catch (Exception e) {
            LogHelper.error("OrderQueryService -> queryOrderDetail异常", e);
        }
        return null;
    }

    public List<OrderFlowItemResp> queryOrderFlow(String orderid) {
        try {
            return orderQueryHttp.queryOrderFlow(orderid);
        } catch (Exception e) {
            LogHelper.error("OrderQueryService -> queryOrderFlow异常", e);
        }
        return null;
    }
}
