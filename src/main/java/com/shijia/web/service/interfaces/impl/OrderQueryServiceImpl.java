package com.shijia.web.service.interfaces.impl;

import com.shijia.web.common.utils.LogHelper;
import com.shijia.web.repository.interfaces.IOrderQueryHttp;
import com.shijia.web.repository.interfaces.entity.resp.OrderFlowItemResp;
import com.shijia.web.repository.interfaces.entity.resp.OrderQueryItemResp;
import com.shijia.web.service.interfaces.IOrderQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author YanxiSir
 * @since 16/8/25
 */
@Service("orderQueryService")
public class OrderQueryServiceImpl implements IOrderQueryService {

    @Autowired
    private IOrderQueryHttp orderQueryHttp;

    public List<OrderQueryItemResp> queryOrderDetail(String str, int tag, int accurate) {

        try {
            return orderQueryHttp.queryOrderDetail(str, tag, accurate);
        } catch (Exception e) {
            LogHelper.error("OrderQueryServiceImpl -> queryOrderDetail异常", e);
        }
        return null;
    }

    public List<OrderFlowItemResp> queryOrderFlow(String orderid) {
        try {
            return orderQueryHttp.queryOrderFlow(orderid);
        } catch (Exception e) {
            LogHelper.error("OrderQueryServiceImpl -> queryOrderFlow异常", e);
        }
        return null;
    }
}
