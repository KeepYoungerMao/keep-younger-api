package com.mao.mapper.data;

import com.mao.entity.food.Collocation;
import com.mao.entity.food.Food;
import com.mao.entity.food.SimpleFood;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 食物数据处理
 * @author mao by 16:33 2019/9/10
 */
@Repository
@Mapper
public interface FoodMapper {

    List<SimpleFood> getFoodByType(@Param("type") int type, @Param("page") int page);

    Food getFoodById(@Param("id") int id);

    List<Collocation> getCollocationByFoodId(@Param("id") int id);

}