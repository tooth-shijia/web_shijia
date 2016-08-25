package com.shijia.web.repository.interfaces.impl;

import com.shijia.web.repository.interfaces.IOrderQueryHttp;
import com.shijia.web.repository.interfaces.entity.resp.OrderQueryItemResp;
import com.shijia.web.repository.util.domain.RESTfulConfigItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author YanxiSir
 * @since 16/8/25
 */
@Repository("orderQueryHttp")
public class OrderQueryHttpImpl implements IOrderQueryHttp{

    @Autowired
    private RESTfulConfigItem orderQueryUrl;

    public List<OrderQueryItemResp> queryOrderDetail(String str, int tag, int accurate) throws Exception {


        return null;
    }
}
