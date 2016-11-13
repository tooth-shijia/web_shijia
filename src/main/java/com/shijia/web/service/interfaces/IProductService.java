package com.shijia.web.service.interfaces;

import com.shijia.web.controller.admin.viewmodel.product.ProductShowModel;
import com.shijia.web.controller.admin.viewmodel.product.ProductTypeModel;
import com.shijia.web.repository.mapper.domain.ProductShow;
import com.shijia.web.service.domain.productshow.AddOrUpProductShowReq;

import java.util.List;

/**
 * @author YanxiSir
 * @since 16/11/7
 */
public interface IProductService {

    public List<ProductTypeModel> getProductTypeAll(int siteId, int parentId);

    public List<ProductShowModel> getProductByPageAndType(int pageIndex, int pageSize, int type);

    public int addProduct(AddOrUpProductShowReq addProductShowReq);

    /**
     * 更新内容
     *
     * @param addOrUpProductShowReq
     * @return
     */
    public int updateProductShowById(AddOrUpProductShowReq addOrUpProductShowReq);

    /**
     * 删除
     *
     * @param id
     * @return
     */
    public int delProductShowById(int id);

    /**
     * 恢复
     *
     * @param id
     * @return
     */
    public int recoverProductShowById(int id);

    /**
     * 获取某类型产品总数
     *
     * @param typeId
     * @return
     */
    public int getTotalCountByTypeId(int typeId);

    /**
     * 按id获取某个产品
     *
     * @param id
     * @return
     */
    public ProductShow getProductById(int id);
}
