package com.shijia.web.service.interfaces.impl;

import com.shijia.web.repository.mapper.IProductTypeDAO;
import com.shijia.web.repository.mapper.ProductShowDAO;
import com.shijia.web.repository.mapper.domain.ProductShow;
import com.shijia.web.repository.mapper.domain.ProductType;
import com.shijia.web.service.interfaces.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author YanxiSir
 * @since 16/11/7
 */
@Service("productService")
public class ProductServiceImpl implements IProductService {

    @Autowired
    private ProductShowDAO productShowDAO;

    @Autowired
    private IProductTypeDAO productTypeDAO;

    public List<ProductType> getProductTypeAll() {
        return productTypeDAO.getProductTypeAll();
    }

    public List<ProductShow> getProductByPageAndType(int pageIndex, int pageSize, int type) {
        int startIndex = (pageIndex - 1) * pageSize;
        return productShowDAO.getProductByPageAndType(startIndex, pageSize, type);
    }

    public int addProduct(ProductShow ps) {
        return productShowDAO.addProductShow(ps);
    }
}
