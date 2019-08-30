package com.mao.mapper.data;

import com.mao.entity.animal.Animal;
import com.mao.entity.animal.SimpleAnimal;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author mao by 15:14 2019/8/30
 */
@Repository
@Mapper
public interface AnimalMapper {

    //根据类别查询动物简单数据
    List<SimpleAnimal> getAnimalByType(@Param("type") int type, @Param("page") int page);

    //根据id查询动物详情数据
    Animal getAnimalById(@Param("id") int id);
}