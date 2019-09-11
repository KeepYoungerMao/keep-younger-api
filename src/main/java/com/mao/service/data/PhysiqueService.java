package com.mao.service.data;

import com.mao.entity.ResponseData;

/**
 * 体质数据处理
 * @author mao by 10:33 2019/9/11
 */
public interface PhysiqueService {

    //根据名称查询体质详情
    ResponseData physique(String name);

}