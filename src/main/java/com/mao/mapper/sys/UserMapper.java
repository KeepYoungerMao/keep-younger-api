package com.mao.mapper.sys;

import com.mao.entity.auth.UserDo;
import com.mao.entity.auth.UserVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * 用户数据
 * @author mao by 10:24 2019/8/30
 */
@Repository
@Mapper
public interface UserMapper {

    //根据app_secret查询用户
    UserDo getUserByAppSecret(@Param("secret") String app_secret);

    //根据user_code查询用户
    UserDo getUserByCode(@Param("code") String user_code);

    //根据user_code查询用户展示信息
    UserVo getUserInfoByCode(@Param("code") String user_code);

}