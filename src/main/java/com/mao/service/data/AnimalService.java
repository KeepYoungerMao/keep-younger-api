package com.mao.service.data;

import com.mao.entity.ResponseData;

/**
 * 动物大全数据处理
 * @author mao by 14:48 2019/8/30
 */
public interface AnimalService {

    //获取动物列表信息（简要列表）
    ResponseData animalList(String type, String page);

    //获取动物详细信息
    ResponseData animalSrc(String id);
}