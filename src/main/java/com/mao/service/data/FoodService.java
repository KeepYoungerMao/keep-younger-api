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

}