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
    public List<NewsShow> getNewsByPageAndTypeContainDelete(int startIndex, int pageSize, int type);

    /**
     * 更新
     *
     * @param newsShow
     * @return
     */
    public int updateNewsShow(NewsShow newsShow);

    /**
     * 通过id获取newsshow
     *
     * @param id
     * @return
     */
    public NewsShow getNewsById(int id);

    /**
     * 获取某个类型新闻 总数
     *
     * @param newsType
     * @return
     */
    public int getTotalCountByTypeId(int newsType);

    /**
     * 删除字段操作
     *
     * @param id
     * @return
     */
    public int delOpeNewsShowById(int deleteOrNot,int id);
}
