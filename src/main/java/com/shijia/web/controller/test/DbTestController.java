package com.shijia.web.controller.test;


import com.shijia.web.service.interfaces.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * @author YanxiSir
 * @since 16/11/9
 */
@Controller
@RequestMapping("/test/db")
public class DbTestController {

    @Autowired
    private IProductService productService;

    @ResponseBody
    @RequestMapping("/getAllProductType")
    public Object getProductType() {
        return productService.getProductTypeAll();
    }


}
