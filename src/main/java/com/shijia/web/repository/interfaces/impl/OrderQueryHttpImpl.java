package com.shijia.web.repository.interfaces.impl;

import com.alibaba.fastjson.JSONObject;
import com.shijia.web.common.utils.StringUtils;
import com.shijia.web.repository.interfaces.IOrderQueryHttp;
import com.shijia.web.repository.interfaces.entity.resp.OrderFlowItemResp;
import com.shijia.web.repository.interfaces.entity.resp.OrderQueryItemResp;
import com.shijia.web.repository.util.HttpUtils;
import com.shijia.web.repository.util.domain.RESTfulConfigItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Objects;

/**
 * @author YanxiSir
 * @since 16/8/25
 */
@Repository("orderQueryHttp")
public class OrderQueryHttpImpl implements IOrderQueryHttp {

    @Autowired
    private RESTfulConfigItem orderQueryUrl;
    @Autowired
    private RESTfulConfigItem orderFlowUrl;

    public List<OrderQueryItemResp> queryOrderDetail(String str, int tag, int accurate) throws Exception {

        String params = "str=" + str + "&tag=" + tag + "&accurate=" + accurate;
        String url = orderQueryUrl.getUrl() + "?" + params;

        String result = HttpUtils.get(url, orderQueryUrl.getTimeout());
        if (StringUtils.isEmpty(result)) {
            return null;
        }
        return JSONObject.parseArray(result, OrderQueryItemResp.class);
    }

    public List<OrderFlowItemResp> queryOrderFlow(String orderid) throws Exception {
        String url = orderFlowUrl.getUrl() + "?orderid=" + orderid;
        String result = HttpUtils.get(url, orderFlowUrl.getTimeout());
        if (StringUtils.isEmpty(result)) {
            return null;
        }
        return JSONObject.parseArray(result, OrderFlowItemResp.class);
    }
}
