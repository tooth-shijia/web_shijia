package com.shijia.web.service;

import com.shijia.web.common.consts.UrlConsts;
import com.shijia.web.common.consts.enums.ESiteType;
import com.shijia.web.common.consts.enums.PageTypeEnum;
import com.shijia.web.common.consts.map.CssClassMapConsts;
import com.shijia.web.common.utils.DateUtils;
import com.shijia.web.common.utils.ImageUrlUtils;
import com.shijia.web.controller.admin.viewmodel.news.NewsShowModel;
import com.shijia.web.controller.admin.viewmodel.product.ProductShowModel;
import com.shijia.web.controller.user.viewmodel.ShowListItemDTO;
import com.shijia.web.repository.mapper.INewDAO;
import com.shijia.web.repository.mapper.domain.NewsShow;
import com.shijia.web.controller.admin.domain.news.AddOrUpNewsReq;
import com.shijia.web.repository.mapper.domain.ProductShow;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * @author YanxiSir
 * @since 16/11/7
 */
@Service
public class NewsService {

    private static final Logger logger = LoggerFactory.getLogger(NewsService.class);
    @Autowired
    private INewDAO newDAO;
    @Autowired
    private CommonService commonService;

    public int addNews(AddOrUpNewsReq req) {
        NewsShow ns = new NewsShow();
        ns.setNewsName(req.getNewsName());
        ns.setAuthor(req.getAuthor());
        ns.setComefrom(req.getComefrom());

        ns.setCreateTime(DateUtils.getCurDate());
        ns.setLastModifyTime(DateUtils.getCurDate());
        ns.setContent(req.getContent());
        ns.setNewsType(req.getNewsType());
        ns.setCoverImage(req.getImageName());

        int result = -1;
        try {
            result = newDAO.addNewsShow(ns);
        } catch (Exception e) {
            logger.error("addNews 异常", e);
        }
        return result;
    }

    public int updateNewsById(AddOrUpNewsReq req) {
        NewsShow ns = new NewsShow();
        ns.setNewsName(req.getNewsName());
        ns.setAuthor(req.getAuthor());
        ns.setComefrom(req.getComefrom());

        ns.setCreateTime(DateUtils.getCurDate());
        ns.setLastModifyTime(DateUtils.getCurDate());
        ns.setContent(req.getContent());
        ns.setNewsType(req.getNewsType());
        ns.setId(req.getId());
        ns.setCoverImage(req.getImageName());

        int result = -1;
        try {
            result = newDAO.updateNewsShow(ns);
        } catch (Exception e) {
            logger.error("updateNews 异常", e);
        }
        return result;
    }

    public NewsShow getNewsById(int id) {
        NewsShow ns = null;
        try {
            ns = newDAO.getNewsById(id);
            if (ns != null) {
                String content = commonService.getURLDecodeString(ns.getContent(), 2);
                ns.setContent(content);
            }
        } catch (Exception e) {
            logger.error("getNewsById 异常", e);
        }
        return ns;
    }

    public List<ShowListItemDTO> getAllNews() {
        List<ShowListItemDTO> showListItemDTOList = new ArrayList<>();
        List<NewsShow> newsShowList = newDAO.getAllNewsSimple();
        if (!CollectionUtils.isEmpty(newsShowList)) {
            for (NewsShow ns : newsShowList) {
                ShowListItemDTO model = new ShowListItemDTO();
                model.setId(ns.getId());
                model.setName(ns.getNewsName());
                model.setTypeId(ns.getNewsType());
                model.setComefrom(ns.getComefrom());
                model.setClassName(CssClassMapConsts.newsCssClassMap.get(ns.getNewsType()));
                String url = MessageFormat.format(UrlConsts.PAGE_DETAIL_URL, PageTypeEnum.NEWS.value(), ns.getId());
                model.setUrl(url);
                model.setCoverImageUrl(ImageUrlUtils.newsCover(ns.getCoverImage()));
                showListItemDTOList.add(model);
            }
        }
        return showListItemDTOList;
    }

    public List<NewsShowModel> getNewsByPageAndType(int pageIndex, int pageSize, int type) {
        int startIndex = (pageIndex - 1) * pageSize;
        List<NewsShowModel> newsShowModelList = null;
        try {
            List<NewsShow> newsShowList = newDAO.getNewsByPageAndTypeContainDelete(startIndex, pageSize, type);
            newsShowModelList = new ArrayList<NewsShowModel>();
            for (NewsShow ns : newsShowList) {
                NewsShowModel newsShowModel = new NewsShowModel();
                newsShowModel.setId(ns.getId());
                newsShowModel.setNewsType(ns.getNewsType());
//                newsShowModel.setContent(ns.getContent());
                newsShowModel.setNewsName(ns.getNewsName());
                newsShowModel.setAuthor(ns.getAuthor());
                newsShowModel.setComefrom(ns.getComefrom());
                newsShowModel.setIsDelete(ns.getIsDelete());
                newsShowModel.setShowCount(ns.getShowCount());

                newsShowModel.setCreateTime(DateUtils.getDate(ns.getCreateTime()));
                newsShowModel.setLastModifyTime(DateUtils.getDate(ns.getLastModifyTime()));
                newsShowModelList.add(newsShowModel);
            }
        } catch (Exception e) {
            logger.error("getNewsByPageAndType 异常", e);
        }
        return newsShowModelList;
    }

    public int getTotalCountByTypeId(int newsType) {
        int total = -1;
        try {
            total = newDAO.getTotalCountByTypeId(newsType);
        } catch (Exception e) {
            logger.error("getTotalCountByTypeId 新闻 异常", e);
        }
        return total;
    }

    public int delNewsShowById(int id) {
        try {
            return newDAO.delOpeNewsShowById(1, id);
        } catch (Exception e) {
            logger.error("delProductShowById 异常", e);
        }
        return -1;
    }

    public int recoverNewsShowById(int id) {
        try {
            return newDAO.delOpeNewsShowById(0, id);
        } catch (Exception e) {
            logger.error("recoverNewsShowById 异常", e);
        }
        return -1;
    }
}
