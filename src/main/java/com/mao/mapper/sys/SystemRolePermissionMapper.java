package com.mao.mapper.sys;

import com.mao.entity.auth.SystemRolePermission;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * 权限查询
 * @author mao by 10:13 2019/8/30
 */
@Repository
@Mapper
public interface SystemRolePermissionMapper {

    //根据用户code查询权限
    SystemRolePermission getSystemRolePermission(@Param("code") String code,
                                                 @Param("permission") String permission);

}