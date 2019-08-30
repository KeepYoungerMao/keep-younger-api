package com.mao.entity.auth;

import lombok.Getter;
import lombok.Setter;

/**
 * 用户表，用于展示数据
 * @author mao by 15:00 2019/8/26
 */
@Getter
@Setter
public class UserVo {
    private long user_id;
    private String user_name;
    private boolean user_locked;
    private String user_login;
    private String user_email;
    private String user_phone;
    private String user_role;
}