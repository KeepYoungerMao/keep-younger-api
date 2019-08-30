package com.mao.mapper.data;

import com.mao.entity.bjx.Surname;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author mao by 16:21 2019/8/30
 */
@Repository
@Mapper
public interface BjxMapper {

    //分页查询百家姓简要列表
    List<Surname> getSurname(@Param("page") int page);

    //根据id查询百家姓详情信息
    Surname getSurnameById(@Param("id") int id);

    //根据name获取百家姓详情信息
    Surname getSurnameByName(@Param("name") String name);
}