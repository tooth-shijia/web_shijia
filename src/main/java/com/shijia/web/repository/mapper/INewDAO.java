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
    int addNewsShow(NewsShow newsShow);

    /**
     * 按新闻类型 分页获取新闻
     *
     * @param startIndex
     * @param pageSize
     * @param type
     * @return
     */
    List<NewsShow> getNewsByPageAndTypeContainDelete(int startIndex, int pageSize, int type);

    /**
     * 更新
     *
     * @param newsShow
     * @return
     */
    int updateNewsShow(NewsShow newsShow);

    /**
     * 通过id获取newsshow
     *
     * @param id
     * @return
     */
    NewsShow getNewsById(int id);

    /**
     * 获取某个类型新闻 总数
     *
     * @param newsType
     * @return
     */
    int getTotalCountByTypeId(int newsType);

    /**
     * 删除字段操作
     *
     * @param id
     * @return
     */
    int delOpeNewsShowById(int deleteOrNot, int id);

    List<NewsShow> getAllNewsSimple();
}
