package com.shijia.web.repository.mapper;

import com.shijia.web.repository.mapper.domain.NewsShow;
import com.shijia.web.repository.mapper.domain.ProductShow;
import com.shijia.web.repository.mapper.domain.ProductType;

/**
 * @author YanxiSir
 * @since 16/5/22
 */
public interface ShijiaWebMapper {

    /**
     * ProductShow
     */
    public int addProductShow(ProductShow productShow);


    /**
     * ProductType
     */
    public int addProductType(ProductType productType);

    /**
     * NewsShow
     */
    public int addNewsShow(NewsShow newsShow);
}
