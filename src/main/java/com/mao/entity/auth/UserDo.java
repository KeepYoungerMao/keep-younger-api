package com.mao.entity.auth;

import lombok.Getter;
import lombok.Setter;

/**
 * 用户表：用户数据查询，不用于用户信息展示
 * @author mao by 15:06 2019/8/23
 */
@Getter
@Setter
public class UserDo {

    private int user_id;
    private String user_name;
    private String user_code;
    private boolean user_locked;
    private String user_login;
    private String user_pass;
    private String user_app_key;
    private String user_app_secret;

}