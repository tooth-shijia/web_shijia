package com.shijia.web.service.interfaces.impl;

import com.shijia.web.repository.mapper.INewDAO;
import com.shijia.web.repository.mapper.domain.NewsShow;
import com.shijia.web.service.interfaces.INewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author YanxiSir
 * @since 16/11/7
 */
@Service("newsService")
public class NewsServiceImpl implements INewsService {

    @Autowired
    private INewDAO newDAO;

    public int addNews(NewsShow ns) {
        return newDAO.addNewsShow(ns);
    }

    public List<NewsShow> getNewsByPageAndType(int pageIndex, int pageSize, int type) {
        int startIndex = (pageIndex - 1) * pageSize;
        return newDAO.getNewsByPageAndType(startIndex, pageSize, type);
    }
}
