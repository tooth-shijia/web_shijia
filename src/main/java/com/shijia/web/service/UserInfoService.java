package com.shijia.web.service;

import com.shijia.web.common.consts.GetUserInfoTypeConst;
import com.shijia.web.repository.mapper.IUserInfoDAO;
import com.shijia.web.repository.mapper.domain.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @author YanxiSir
 * @since 16/11/30
 */
@Service
public class UserInfoService {

    @Autowired
    private IUserInfoDAO userInfoDAO;


    public UserInfo getUserInfoByAllDim(String username){
        return userInfoDAO.getUserInfoAllDim(username);
    }

    public UserInfo getUserInfoByUserId(String userId) {
        return getUserInfo(GetUserInfoTypeConst.USER_ID_FOR_INFO, userId);
    }

    public UserInfo getUserInfoByPhone(String phone) {
        return getUserInfo(GetUserInfoTypeConst.PHONE_FOR_INFO, phone);
    }

    public UserInfo getUserInfoByEmail(String email) {
        return getUserInfo(GetUserInfoTypeConst.EMAIL_FOR_INFO, email);
    }


    /**
     *==================== private ================
     */




    private UserInfo getUserInfo(int type, String value) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("type", type);
        map.put("value", value);
        return userInfoDAO.getUserInfoByValue(map);
    }
}
