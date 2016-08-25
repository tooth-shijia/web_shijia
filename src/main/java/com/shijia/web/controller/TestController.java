package com.shijia.web.controller;

import com.alibaba.fastjson.JSON;
import com.shijia.web.repository.interfaces.entity.resp.OrderQueryItemResp;
import com.shijia.web.service.interfaces.IOrderQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author YanxiSir
 * @since 16/8/25
 */
@Controller
public class TestController {

    @Autowired
    private IOrderQueryService orderQueryService;

    @ResponseBody
    @RequestMapping(value = "/test/query" , produces = "text/plain;charset=utf-8")
    public String test() {

        List<OrderQueryItemResp> resp = orderQueryService.queryOrderDetail("20151123A018", 1, 2);
        return JSON.toJSONString(resp);
    }
}
