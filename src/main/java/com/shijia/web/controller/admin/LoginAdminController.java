package com.shijia.web.controller.admin;

import com.alibaba.fastjson.JSON;
import com.shijia.web.common.domain.AjaxResult;
import com.shijia.web.controller.viewmodel.admin.login.LoginAdminReqModel;
import com.shijia.web.service.interfaces.ICommonService;
import com.shijia.web.service.interfaces.ILoginAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;

/**
 * @author YanxiSir
 * @since 16/5/21
 */
@Controller
@RequestMapping("/admin")
public class LoginAdminController {

    @Autowired
    private ICommonService commonService;
    @Autowired
    private ILoginAdminService loginAdminServiceImpl;

    @RequestMapping("/login")
    public String adminLogin() {
        return "admin/login";
    }


    /**
     * ajax请求
     */

    @ResponseBody
    @RequestMapping("/ajax/loginSubmit")
    public AjaxResult adminLoginSubmit(String value) {
        LoginAdminReqModel model = JSON.parseObject(value,LoginAdminReqModel.class);
        model.setPassword(commonService.getURLDecodeString(model.getPassword()));
        String username = model.getUsername();
        String password = model.getPassword();
        HashMap<String, String> map = initAdminUser();
        if (map.containsKey(username) && map.get(username).equals(password)) {
            //登录成功,写登录态
            loginAdminServiceImpl.setLoginStatus(model);
            return new AjaxResult(true, "success", null);
        } else {
            if (map.containsKey(username)) {
                //密码错误
                return new AjaxResult(false, "密码错误");
            } else {
                //用户不存在
                return new AjaxResult(false, "用户名不存在");
            }
        }
    }

    private HashMap<String, String> initAdminUser() {
        HashMap<String, String> map = new HashMap<String, String>();
        map.put("admin1", "nopass.a1");
        map.put("admin2", "nopass.a2");
        map.put("admin3", "nopass.a3");
        return map;
    }
}
