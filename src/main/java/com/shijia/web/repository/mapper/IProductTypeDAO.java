package com.shijia.web.repository.mapper;

import com.shijia.web.repository.mapper.domain.ProductType;

import java.util.List;

/**
 * @author YanxiSir
 * @since 16/11/6
 */
public interface IProductTypeDAO {

    /**
     * 增加一个产品类型
     */
    public int addProductType(ProductType productType);

    /**
     * 获取所有产品类型list
     *
     * @return
     */
    public List<ProductType> getProductTypeAll();

}
