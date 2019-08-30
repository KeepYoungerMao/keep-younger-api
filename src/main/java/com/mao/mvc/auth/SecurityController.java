package com.mao.mvc.auth;

import com.mao.entity.ResponseData;
import com.mao.service.auth.SecurityService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * 获取token、刷新token
 * @author mao by 11:48 2019/8/23
 */
@RestController
@RequestMapping("auth")
public class SecurityController {

    @Resource
    private SecurityService securityService;

    /**
     * 获取token、刷新token
     * @param type 类型：auth、refresh
     * @param app_key 用户接口密钥
     * @param app_secret 用户接口专用名
     * @return token信息
     */
    @RequestMapping(value = "token", method = RequestMethod.GET)
    public ResponseData token(String type, String app_key, String app_secret, String refresh){
        return securityService.getAuthToken(type,app_key,app_secret,refresh);
    }

    /**
     * 获取用户信息，获取token（模拟登录）后的信息请求
     * @param request request
     * @return user info
     */
    @RequestMapping(value = "user", method = RequestMethod.GET)
    public ResponseData user(HttpServletRequest request){
        return securityService.getUser(request);
    }

}