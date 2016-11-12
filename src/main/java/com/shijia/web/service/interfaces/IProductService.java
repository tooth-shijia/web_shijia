package com.shijia.web.service.interfaces;

import com.shijia.web.controller.admin.viewmodel.product.ProductShowModel;
import com.shijia.web.repository.mapper.domain.ProductShow;
import com.shijia.web.repository.mapper.domain.ProductType;
import com.shijia.web.service.domain.productshow.AddProductShowReq;

import java.util.List;

/**
 * @author YanxiSir
 * @since 16/11/7
 */
public interface IProductService {

    public List<ProductType> getProductTypeAll();

    public List<ProductShowModel> getProductByPageAndType(int pageIndex, int pageSize, int type);

    public int addProduct(AddProductShowReq addProductShowReq);
}
