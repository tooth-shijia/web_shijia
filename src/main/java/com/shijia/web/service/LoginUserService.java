package com.shijia.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author YanxiSir
 * @since 16/11/30
 */
@Service
public class LoginUserService {

    @Autowired
    private UserInfoService userInfoService;
}
