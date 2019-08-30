package com.mao.entity.auth;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author mao by 16:14 2019/8/20
 */
@Getter
@Setter
@ToString
public class SystemRolePermission {
    private boolean exist;          //是否存在该用户
    private boolean locked;         //用户是否锁定
    private boolean permission;     //是否具有该权限
}