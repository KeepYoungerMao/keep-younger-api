package com.mao.service.data;

import com.mao.entity.ResponseData;

/**
 * @author mao by 10:37 2019/9/4
 */
public interface DrugService {

    //根据分类获取中草药的简要列表
    ResponseData crudeDrugList(String trait, String flavor, String tropism, String page);

    //根据id查询中草药详细详细信息
    ResponseData crudeDrugSrc(String id);

    //根据分类获取成品药简要列表
    ResponseData drugList(String fl, String jx, String lb, String page);

    //根据id查询成品药详情信息
    ResponseData drugSrc(String id);
}