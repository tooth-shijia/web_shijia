package com.shijia.web.repository.mapper;

import com.shijia.web.repository.mapper.domain.ProductShow;

import java.util.List;

/**
 * @author YanxiSir
 * @since 16/11/6
 */
public interface ProductShowDAO {

    /**
     * 新增一个产品
     *
     * @param productShow
     * @return
     */
    public int addProductShow(ProductShow productShow);

    /**
     * 按产品类型 分页获取产品
     *
     * @param startIndex
     * @param pageSize
     * @param productType
     * @return
     */
    public List<ProductShow> getProductByPageAndType(int startIndex, int pageSize, int productType);
}
