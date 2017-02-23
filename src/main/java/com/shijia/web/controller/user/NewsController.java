package com.shijia.web.controller.user;

import com.shijia.web.common.consts.enums.ESiteType;
import com.shijia.web.common.utils.CollectionUtils;
import com.shijia.web.controller.admin.viewmodel.product.ProductTypeModel;
import com.shijia.web.controller.user.viewmodel.BaseDTO;
import com.shijia.web.controller.user.viewmodel.ShowListPageDTO;
import com.shijia.web.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

/**
 * @author YanxiSir
 * @since 17/2/23
 */
@Controller
@RequestMapping("/web/shijia")
public class NewsController {


    @Autowired
    private NewsService newsService;

    @RequestMapping("/news/list")
    public ModelAndView news() {

        ModelAndView model = new ModelAndView("h5/showlist");

        ShowListPageDTO dto = new ShowListPageDTO();
        BaseDTO baseDTO = new BaseDTO();

        dto.setTitle(BaseDTO.NEWS_TITLE);
        dto.setDesc("世佳义齿新闻动态");
        baseDTO.setCurPage(BaseDTO.NEWS);


        dto.setTypeItemVMList(getNewsType());
        dto.setTypeSize(dto.getTypeItemVMList().size());

        model.addObject("mv", dto);
        model.addObject("base", baseDTO);
        return model;

    }

    private List<ShowListPageDTO.TypeItemVM> getNewsType() {
        List<ShowListPageDTO.TypeItemVM> list = new ArrayList<>();
        list.add(new ShowListPageDTO.TypeItemVM(1, "公司新闻"));
        list.add(new ShowListPageDTO.TypeItemVM(2, "行业动态"));
        return list;
    }
}
