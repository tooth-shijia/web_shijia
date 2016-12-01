package com.shijia.web.controller.user.ajax;

import com.shijia.web.common.domain.AjaxResult;
import com.shijia.web.common.utils.StringUtils;
import com.shijia.web.controller.admin.domain.login.LoginAdminReq;
import com.shijia.web.repository.mapper.domain.UserInfo;
import com.shijia.web.service.CommonService;
import com.shijia.web.service.LoginUserService;
import com.shijia.web.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author YanxiSir
 * @since 16/12/1
 */
@Controller
@RequestMapping("/user/ajax")
public class LoginUserAjaxController {

    @Autowired
    private CommonService commonService;
    @Autowired
    private UserInfoService userInfoService;
    @Autowired
    private LoginUserService loginUserService;

    @ResponseBody
    @RequestMapping("/loginSubmit")
    public AjaxResult userLoginSubmit(@RequestBody LoginAdminReq model) {
        AjaxResult result = new AjaxResult();
        model.setPassword(commonService.getURLDecodeString(model.getPassword()));
        String username = model.getUsername();
        String password = model.getPassword();
        if (StringUtils.isEmpty(username) || StringUtils.isEmpty(password)) {
            result.setSuccess(false);
            result.setMsg("用户名或密码不能为空");
        }
        UserInfo userInfo = userInfoService.getUserInfoByAllDim(username);
        if (userInfo == null) {
            result.setSuccess(false);
            result.setMsg("该用户未注册");
        } else {
            if (!password.equals(userInfo.getPassword())) {
                result.setSuccess(false);
                result.setMsg("用户名或密码错误");
            } else {
                //记录登录态

                result.setSuccess(true);
                result.setMsg("登录成功");
            }
        }
        return result;
    }
}
