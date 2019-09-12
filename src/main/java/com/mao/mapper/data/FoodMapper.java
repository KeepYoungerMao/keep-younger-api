package com.mao.mapper.data;

import com.mao.entity.food.*;
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

    //根据类型查询简要食物列表
    List<SimpleFood> getFoodByType(@Param("type") int type, @Param("page") int page);

    //根据id查询食物详细信息
    Food getFoodById(@Param("id") int id);

    //根据食物id查询该食物搭配禁忌
    List<Collocation> getCollocationByFoodId(@Param("id") int id);

    //根据类型查询食物原材料简要列表
    List<SimpleIngredient> getFoodIngredientByType(@Param("type") int type, @Param("page") int page);

    //根据id查询食物原材料详细信息
    Ingredient getFoodIngredientById(@Param("id") int id);

    //根据食物原材料类别查看指定营养类别排行
    List<Nutrition> getFoodIngredientNutrition(@Param("type") int type, @Param("kind") int kind);

    //获取食谱简要列表
    List<SimpleRecipe> getFoodRecipe(@Param("page") int page);

    //根据id获取食谱详细信息
    Recipe getFoodRecipeById(@Param("id") int id);
}