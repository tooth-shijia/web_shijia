package com.shijia.web.repository.mapper;

import com.shijia.web.repository.mapper.domain.UserInfo;

import java.util.Map;

/**
 * @author YanxiSir
 * @since 16/11/30
 */
public interface IUserInfoDAO {

    /**
     * 获取用户信息  type: 1-userId;2-phone;3-email
     *
     * @param map
     * @return
     */
    UserInfo getUserInfoByValue(Map map);

    /**
     * 插入新用户
     *
     * @param userInfo
     * @return
     */
    int insertNewUser(UserInfo userInfo);
}
