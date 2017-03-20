package com.shijia.web.controller.user;

import com.shijia.web.common.consts.enums.PageTypeEnum;
import com.shijia.web.controller.user.viewmodel.BaseDTO;
import com.shijia.web.controller.user.viewmodel.ShowPageDetailDTO;
import com.shijia.web.repository.mapper.domain.NewsShow;
import com.shijia.web.repository.mapper.domain.ProductShow;
import com.shijia.web.service.NewsService;
import com.shijia.web.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author YanxiSir
 * @since 17/3/20
 */
@Controller
@RequestMapping("/web/shijia")
public class DetailPageController {

    @Autowired
    private NewsService newsService;
    @Autowired
    private ProductService productService;

    @RequestMapping("/page/{type}/{id}/detail")
    public ModelAndView detailPage(@PathVariable int type, @PathVariable int id) {
        ModelAndView model = new ModelAndView("h5/detail-page");
        ShowPageDetailDTO detailDTO = new ShowPageDetailDTO();
        BaseDTO baseDTO = new BaseDTO();
        if (type == PageTypeEnum.PRODUCT_SHIJIA.value()
                || type == PageTypeEnum.PRODUCT_BEIYI.value()) {
            ProductShow productShow = productService.getProductById(id);
            if (productShow != null) {
                detailDTO.setTitle(productShow.getProductName());
                detailDTO.setAuthor(productShow.getAuthor());
                detailDTO.setComefrom(productShow.getComefrom());
                detailDTO.setContent(productShow.getContent());
            }
            if (type == PageTypeEnum.PRODUCT_SHIJIA.value()) {
                baseDTO.setCurPage(BaseDTO.SHIJIA);
            } else {
                baseDTO.setCurPage(BaseDTO.BEIYI);
            }
        } else if (type == PageTypeEnum.NEWS.value()) {
            NewsShow newsShow = newsService.getNewsById(id);
            detailDTO.setTitle(newsShow.getNewsName());
            detailDTO.setAuthor(newsShow.getAuthor());
            detailDTO.setComefrom(newsShow.getComefrom());
            detailDTO.setContent(newsShow.getContent());
            baseDTO.setCurPage(BaseDTO.NEWS);
        }
        model.addObject("mv", detailDTO);
        model.addObject("base", baseDTO);
        return model;
    }
}
