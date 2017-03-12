package com.shijia.web.repository.mapper;

import com.shijia.web.repository.mapper.domain.ProductShow;
import org.apache.ibatis.annotations.Param;

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
    public List<ProductShow> getProductByPageAndTypeContainDelete(int startIndex, int pageSize, int productType);

    /**
     * 按站点获取产品简单列表
     *
     * @param site
     * @return
     */
    public List<ProductShow> getAllProductSimpleBySite(@Param("site") int site);

    /**
     * 更新内容
     *
     * @param productShow
     * @return
     */
    public int updateProductShowById(ProductShow productShow);

    /**
     * 删除 or 恢复
     *
     * @param deleteOrNot 1，删除 ； 0，恢复
     * @param id
     * @return
     */
    public int delOpeProductShowById(int deleteOrNot, int id);

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
