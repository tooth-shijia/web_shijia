package com.shijia.web.controller.test;

import com.alibaba.fastjson.JSON;
import com.shijia.web.repository.interfaces.entity.resp.OrderFlowItemResp;
import com.shijia.web.repository.interfaces.entity.resp.OrderQueryItemResp;
import com.shijia.web.repository.mapper.INewDAO;
import com.shijia.web.service.interfaces.IOrderQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author YanxiSir
 * @since 16/11/9
 */
@Controller
@RequestMapping("/test/outapi")
public class OuterInterfaceTestController {
    @Autowired
    private IOrderQueryService orderQueryService;

    @Autowired
    private INewDAO newDAO;

    @ResponseBody
    @RequestMapping(value = "/query", produces = "text/plain;charset=utf-8")
    public String test() {

        List<OrderQueryItemResp> resp = orderQueryService.queryOrderDetail("20151123A018", 1, 2);
        return JSON.toJSONString(resp);
    }

    @ResponseBody
    @RequestMapping(value = "/flow", produces = "text/plain;charset=utf-8")
    public String test2() {

        List<OrderFlowItemResp> resp = orderQueryService.queryOrderFlow("20160818D010");
        return JSON.toJSONString(resp);
    }

    @ResponseBody
    @RequestMapping("/testdao")
    public String testDao() {
        return "success";
    }
}
