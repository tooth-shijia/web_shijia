package com.shijia.web.service.interfaces;

import com.shijia.web.controller.admin.viewmodel.news.NewsShowModel;
import com.shijia.web.repository.mapper.domain.NewsShow;
import com.shijia.web.service.domain.news.AddOrUpNewsReq;

import java.util.List;

/**
 * @author YanxiSir
 * @since 16/11/7
 */
public interface INewsService {

    public int addNews(AddOrUpNewsReq req);

    public int updateNewsById(AddOrUpNewsReq req);

    public NewsShow getNewsById(int id);

    public List<NewsShowModel> getNewsByPageAndType(int pageIndex, int pageSize, int type);

    public int getTotalCountByTypeId(int newsType);

    /**
     * 删除
     *
     * @param id
     * @return
     */
    public int delNewsShowById(int id);

    /**
     * 恢复
     *
     * @param id
     * @return
     */
    public int recoverNewsShowById(int id);
}
