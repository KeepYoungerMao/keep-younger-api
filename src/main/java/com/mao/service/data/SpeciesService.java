package com.mao.service.data;

import com.mao.entity.ResponseData;

/**
 * 物种数据请求
 * @author mao by 11:09 2019/8/30
 */
public interface SpeciesService {

    //获取物种树类信息
    ResponseData speciesTrees(String id);

    //获取物种详细信息（列表信息）
    ResponseData speciesListSrc(String id);

}