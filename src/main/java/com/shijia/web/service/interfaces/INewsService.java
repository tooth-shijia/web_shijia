package com.shijia.web.service.interfaces;

import com.shijia.web.repository.mapper.domain.NewsShow;

import java.util.List;

/**
 * @author YanxiSir
 * @since 16/11/7
 */
public interface INewsService {

    public int addNews(NewsShow ns);

    public List<NewsShow> getNewsByPageAndType(int pageIndex, int pageSize, int type);
}
