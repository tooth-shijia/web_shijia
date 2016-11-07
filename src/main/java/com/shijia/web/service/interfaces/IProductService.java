package com.shijia.web.service.interfaces;

import com.shijia.web.repository.mapper.domain.ProductShow;
import com.shijia.web.repository.mapper.domain.ProductType;

import java.util.List;

/**
 * @author YanxiSir
 * @since 16/11/7
 */
public interface IProductService {

    public List<ProductType> getProductTypeAll();

    public List<ProductShow> getProductByPageAndType(int pageIndex, int pageSize, int type);

    public int addProduct(ProductShow ps);
}
