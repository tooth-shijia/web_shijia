package com.shijia.web.service.interfaces.impl;

import com.shijia.web.repository.mapper.IProductTypeDAO;
import com.shijia.web.repository.mapper.ProductShowDAO;
import com.shijia.web.repository.mapper.domain.ProductShow;
import com.shijia.web.repository.mapper.domain.ProductType;
import com.shijia.web.service.domain.productshow.AddProductShowReq;
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

    /**
     * 获取所有产品类型
     *
     * @return
     */
    public List<ProductType> getProductTypeAll() {
        return productTypeDAO.getProductTypeAll();
    }

    /**
     * 按类型分页获取产品
     *
     * @param pageIndex
     * @param pageSize
     * @param type
     * @return
     */
    public List<ProductShow> getProductByPageAndType(int pageIndex, int pageSize, int type) {
        int startIndex = (pageIndex - 1) * pageSize;
        return productShowDAO.getProductByPageAndType(startIndex, pageSize, type);
    }

    /**
     * 增加产品
     *
     * @return
     */
    public int addProduct(AddProductShowReq addProductShowReq) {
        ProductShow ps = new ProductShow();
        ps.setProductName(addProductShowReq.getProductName());
        ps.setProductTypeId(addProductShowReq.getProductTypeId());
        ps.setProductTypeName(addProductShowReq.getProductTypeName());
        ps.setContent(addProductShowReq.getContent());
        return productShowDAO.addProductShow(ps);
    }
}
