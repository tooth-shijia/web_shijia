package com.shijia.web.service;

import com.shijia.web.common.consts.UrlConsts;
import com.shijia.web.common.consts.enums.ESiteType;
import com.shijia.web.common.consts.enums.PageTypeEnum;
import com.shijia.web.common.consts.map.CssClassMapConsts;
import com.shijia.web.common.framework.annotation.IgnoreException;
import com.shijia.web.common.utils.DateUtils;
import com.shijia.web.common.utils.StringUtils;
import com.shijia.web.controller.admin.viewmodel.product.ProductShowModel;
import com.shijia.web.controller.admin.viewmodel.product.ProductTypeModel;
import com.shijia.web.controller.user.viewmodel.ShowListItemDTO;
import com.shijia.web.repository.mapper.IProductTypeDAO;
import com.shijia.web.repository.mapper.ProductShowDAO;
import com.shijia.web.repository.mapper.domain.ProductShow;
import com.shijia.web.repository.mapper.domain.ProductType;
import com.shijia.web.controller.admin.domain.productshow.AddOrUpProductShowReq;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author YanxiSir
 * @since 16/11/7
 */
@IgnoreException
@Service
public class ProductService {

    private static final Logger logger = LoggerFactory.getLogger(ProductService.class);

    @Autowired
    private ProductShowDAO productShowDAO;

    @Autowired
    private IProductTypeDAO productTypeDAO;

    @Autowired
    private CommonService commonService;

    /**
     * 获取所有产品类型（1：世佳 ； 2：贝艺）
     *
     * @param siteId
     * @param parentId 世佳获取所有类型 ； 贝艺，parentId=-1 获取parent 否则获取child
     * @return
     */
    public List<ProductTypeModel> getProductTypeAll(int siteId, int parentId) {
        List<ProductTypeModel> modelList = null;
        try {
            List<ProductType> list = productTypeDAO.getProductTypeAll(siteId);
            modelList = new ArrayList<ProductTypeModel>();
            if (parentId <= 0) {
                Map<Integer, String> map = new HashMap<Integer, String>();
                for (ProductType type : list) {
                    if (!map.containsKey(type.getParentTypeId())) {
                        map.put(type.getParentTypeId(), type.getParentTypeName());
                    }
                }
                for (Map.Entry entry : map.entrySet()) {
                    ProductTypeModel item = new ProductTypeModel();
                    Integer key = (Integer) entry.getKey();
                    item.setTypeId(key);
                    item.setTypeName((String) entry.getValue());
                    if (siteId == ESiteType.SITE_SHIJIA.value()) {
                        item.setClassName("filter-" + CssClassMapConsts.shijiaCssClassMap.get(key));
                    } else {
                        item.setClassName("filter-" + CssClassMapConsts.beiyiCssClassMap.get(key));
                    }
                    modelList.add(item);
                }
            } else {
                Map<Integer, String> map = new HashMap<Integer, String>();
                for (ProductType type : list) {
                    if (type.getParentTypeId() != parentId) continue;
                    if (!map.containsKey(type.getTypeId())) {
                        map.put(type.getTypeId(), type.getTypeName());
                    }
                }
                for (Map.Entry entry : map.entrySet()) {
                    ProductTypeModel item = new ProductTypeModel();
                    Integer key = (Integer) entry.getKey();
                    item.setTypeId(key);
                    item.setTypeName((String) entry.getValue());
                    if (siteId == ESiteType.SITE_SHIJIA.value()) {
                        item.setClassName("filter-" + CssClassMapConsts.shijiaCssClassMap.get(key));
                    } else {
                        item.setClassName("filter-" + CssClassMapConsts.beiyiCssClassMap.get(key));
                    }
                    modelList.add(item);
                }
            }

        } catch (Exception e) {
            logger.error("getProductTypeAll 异常", e);
        }
        return modelList;
    }

    /**
     * 按类型分页获取产品(包括delete)
     *
     * @param pageIndex
     * @param pageSize
     * @param type
     * @return
     */
    public List<ProductShowModel> getProductByPageAndType(int pageIndex, int pageSize, int type) {
        int startIndex = (pageIndex - 1) * pageSize;
        List<ProductShowModel> modelList = null;
        try {
            List<ProductShow> list = productShowDAO.getProductByPageAndTypeContainDelete(startIndex, pageSize, type);
            modelList = new ArrayList<ProductShowModel>();
            if (list != null) {
                for (ProductShow ps : list) {
                    ProductShowModel item = new ProductShowModel();
                    item.setId(ps.getId());
                    if (StringUtils.isNotEmpty(ps.getProductName()))
                        item.setProductName(ps.getProductName());
                    if (StringUtils.isNotEmpty(ps.getProductId()))
                        item.setProductId(ps.getProductId());
                    item.setProductTypeId(ps.getProductTypeId());
                    if (StringUtils.isNotEmpty(ps.getProductTypeName()))
                        item.setProductTypeName(ps.getProductTypeName());
                    if (StringUtils.isNotEmpty(ps.getAuthor()))
                        item.setAuthor(ps.getAuthor());
                    if (StringUtils.isNotEmpty(ps.getComefrom()))
                        item.setComefrom(ps.getComefrom());
                    item.setShowCount(ps.getShowCount());
//                    item.setContent(commonService.getURLDecodeString(ps.getContent()));
                    item.setIsDelete(ps.getIsDelete());
                    item.setImageUrl(ps.getCoverImage());
                    if (ps.getCreateTime() != null)
                        item.setCreateTime(DateUtils.getDate(ps.getCreateTime()));
                    if (ps.getLastModifyTime() != null)
                        item.setLastModifyTime(DateUtils.getDate(ps.getLastModifyTime()));
                    modelList.add(item);
                }
            }
        } catch (Exception e) {
            logger.error("getProductByPageAndType 异常", e);
        }
        return modelList;
    }

    /**
     * 按站点获取产品列表
     *
     * @param site
     * @return
     */
    public List<ShowListItemDTO> getAllProductInSite(int site) {
        List<ShowListItemDTO> showListItemDTOList = new ArrayList<>();
        List<ProductShow> productShowList = productShowDAO.getAllProductSimpleBySite(site);
        if (!CollectionUtils.isEmpty(productShowList)) {
            for (ProductShow ps : productShowList) {
                ShowListItemDTO model = new ShowListItemDTO();
                model.setId(ps.getId());
                model.setName(ps.getProductName());
                model.setBodyId(ps.getProductId());
                model.setTypeId(ps.getProductTypeId());
                model.setComefrom(ps.getComefrom());
                if (site == ESiteType.SITE_SHIJIA.value()) {
                    model.setClassName(CssClassMapConsts.shijiaCssClassMap.get(ps.getProductTypeId()));
                    String url = MessageFormat.format(UrlConsts.PAGE_DETAIL_URL, PageTypeEnum.PRODUCT_SHIJIA.value(), ps.getId());
                    model.setUrl(url);
                } else {
                    model.setClassName(CssClassMapConsts.beiyiCssClassMap.get(ps.getProductTypeId()));
                    String url = MessageFormat.format(UrlConsts.PAGE_DETAIL_URL, PageTypeEnum.PRODUCT_BEIYI.value(), ps.getId());
                    model.setUrl(url);
                }
                showListItemDTOList.add(model);
            }
        }
        return showListItemDTOList;
    }

    /**
     * 增加产品
     *
     * @return
     */
    public int addProduct(AddOrUpProductShowReq addProductShowReq) {
        ProductShow ps = new ProductShow();
        ps.setProductName(addProductShowReq.getProductName());
        ps.setProductTypeId(addProductShowReq.getProductTypeId());
        ps.setProductTypeName(addProductShowReq.getProductTypeName());
        ps.setContent(addProductShowReq.getContent());
        ps.setProductId(addProductShowReq.getProductId());
        ps.setCreateTime(DateUtils.getCurDate());
        ps.setLastModifyTime(DateUtils.getCurDate());
        ps.setAuthor(addProductShowReq.getAuthor());
        ps.setComefrom(addProductShowReq.getComefrom());
        ps.setProductClassify(addProductShowReq.getSiteId());
        ps.setCoverImage(addProductShowReq.getImageName());
        int result = -1;
        try {
            result = productShowDAO.addProductShow(ps);
        } catch (Exception e) {
            logger.error("addProduct 异常", e);
        }
        return result;
    }

    /**
     * 更新产品show信息
     *
     * @param updateProductShowReq
     * @return
     */
    public int updateProductShowById(AddOrUpProductShowReq updateProductShowReq) {
        ProductShow ps = new ProductShow();
        ps.setProductName(updateProductShowReq.getProductName());
        ps.setProductTypeId(updateProductShowReq.getProductTypeId());
        ps.setProductTypeName(updateProductShowReq.getProductTypeName());
        ps.setContent(updateProductShowReq.getContent());
        ps.setProductId(updateProductShowReq.getProductId());
        ps.setLastModifyTime(DateUtils.getCurDate());
        ps.setAuthor(updateProductShowReq.getAuthor());
        ps.setComefrom(updateProductShowReq.getComefrom());
        ps.setId(updateProductShowReq.getId());
        ps.setProductClassify(updateProductShowReq.getSiteId());
        ps.setCoverImage(updateProductShowReq.getImageName());
        int result = -1;
        try {
            result = productShowDAO.updateProductShowById(ps);
        } catch (Exception e) {
            logger.error("updateProductShowById 异常", e);
        }
        return result;
    }

    /**
     * 删除
     *
     * @param id
     * @return
     */
    public int delProductShowById(int id) {
        try {
            return productShowDAO.delOpeProductShowById(1, id);
        } catch (Exception e) {
            logger.error("delProductShowById 异常", e);
        }
        return -1;
    }

    /**
     * 恢复
     *
     * @param id
     * @return
     */
    public int recoverProductShowById(int id) {
        try {
            return productShowDAO.delOpeProductShowById(0, id);
        } catch (Exception e) {
            logger.error("recoverProductShowById 异常", e);
        }
        return -1;
    }

    /**
     * 获取某类型产品总数
     *
     * @param typeId
     * @return
     */
    public int getTotalCountByTypeId(int typeId) {
        int total = -1;
        try {
            total = productShowDAO.getTotalCountByTypeId(typeId);
        } catch (Exception e) {
            logger.error("getTotalCountByTypeId 异常", e);
        }
        return total;
    }

    /**
     * 按id获取某个产品
     *
     * @param id
     * @return
     */
    public ProductShow getProductById(int id) {
        ProductShow productShow = new ProductShow();
        try {
            productShow = productShowDAO.getProductById(id);
            if (productShow != null) {
                String content = commonService.getURLDecodeString(productShow.getContent(), 2);
                productShow.setContent(content);
            }
        } catch (Exception e) {
            logger.error("getProductById 异常", e);
        }
        return productShow;
    }
}
