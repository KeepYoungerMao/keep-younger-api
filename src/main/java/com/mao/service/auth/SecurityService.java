package com.mao.service.auth;

import com.mao.entity.ResponseData;

import javax.servlet.http.HttpServletRequest;

/**
 * 授权
 * @author mao by 11:50 2019/8/23
 */
public interface SecurityService {

    //获取token：auth类型
    ResponseData getAuthToken(String type, String app_key, String app_secret, String refresh);

    //获取用户信息
    ResponseData getUser(HttpServletRequest request);
}