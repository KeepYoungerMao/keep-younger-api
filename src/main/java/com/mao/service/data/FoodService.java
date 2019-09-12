package com.mao.service.data;

import com.mao.entity.ResponseData;

/**
 * @author mao by 16:28 2019/9/10
 */
public interface FoodService {

    //根据类型查询食物的简要列表
    ResponseData foodList(String type, String page);

    //根据id查询食物详情信息
    ResponseData foodSrc(String id);

    //根据分类查询食物原材料简要列表
    ResponseData foodIngredientList(String type, String page);

    //根据id查询食物原材料详细信息
    ResponseData foodIngredientSrc(String id);

    //根据食物原材料类别查看指定营养类别排行
    ResponseData foodIngredientNutrition(String type, String kind);

    //查询食谱简要列表
    ResponseData foodRecipeList(String page);

    //根据id获取食谱详细信息
    ResponseData foodRecipeSrc(String id);

}