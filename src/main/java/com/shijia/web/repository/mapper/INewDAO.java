package com.shijia.web.repository.mapper;

import com.shijia.web.repository.mapper.domain.NewsShow;

import java.util.List;

/**
 * @author YanxiSir
 * @since 16/11/6
 */
public interface INewDAO {
    /**
     * NewsShow
     */
    public int addNewsShow(NewsShow newsShow);

    /**
     * 按新闻类型 分页获取新闻
     *
     * @param startIndex
     * @param pageSize
     * @param type
     * @return
     */
    public List<NewsShow> getNewsByPageAndType(int startIndex, int pageSize, int type);


}
