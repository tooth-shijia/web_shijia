package com.shijia.web.controller.user;

import com.shijia.web.common.consts.enums.ESiteType;
import com.shijia.web.common.domain.AjaxResult;
import com.shijia.web.common.utils.CollectionUtils;
import com.shijia.web.controller.admin.viewmodel.product.ProductTypeModel;
import com.shijia.web.controller.user.viewmodel.BaseDTO;
import com.shijia.web.controller.user.viewmodel.ShowListPageDTO;
import com.shijia.web.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

/**
 * @author YanxiSir
 * @since 17/2/22
 */
@Controller
@RequestMapping("/web/shijia")
public class ProductController {

    @Autowired
    private ProductService productService;

    @RequestMapping("/product/{site}/list")
    public ModelAndView product(@PathVariable int site) {
        ModelAndView model = new ModelAndView("h5/showlist");

        ShowListPageDTO dto = new ShowListPageDTO();
        BaseDTO baseDTO = new BaseDTO();

        if (site == ESiteType.SITE_SHIJIA.value()) {
            dto.setTitle("世佳产品");
            dto.setDesc("世佳系列产品");
            baseDTO.setCurPage(BaseDTO.SHIJIA);
        } else {
            dto.setTitle("贝艺数字产品");
            dto.setDesc("贝艺高端系列产品");
            baseDTO.setCurPage(BaseDTO.BEIYI);
        }
        List<ProductTypeModel> typeModels = productService.getProductTypeAll(site, 0);
        if (CollectionUtils.isNotEmpty(typeModels)) {
            dto.setTypeSize(typeModels.size());
        }
        dto.setTypeItemVMList(transferType(typeModels));
        model.addObject("mv", dto);
        model.addObject("base", baseDTO);
        return model;
    }

    @RequestMapping("/product/list")
    public AjaxResult getProduct(int opt) {
        return null;
    }


    private List<ShowListPageDTO.TypeItemVM> transferType(List<ProductTypeModel> productTypeModelList) {
        List<ShowListPageDTO.TypeItemVM> vmList = new ArrayList<>();
        if (CollectionUtils.isNotEmpty(productTypeModelList)) {
            for (ProductTypeModel model : productTypeModelList) {
                ShowListPageDTO.TypeItemVM vm = new ShowListPageDTO.TypeItemVM();
                vm.setId(model.getTypeId());
                vm.setName(model.getTypeName());
                vmList.add(vm);
            }
        }
        return vmList;
    }
}
