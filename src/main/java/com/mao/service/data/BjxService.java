package com.mao.service.data;

import com.mao.entity.ResponseData;

/**
 * 百家姓（姓氏）数据处理
 * @author mao by 16:20 2019/8/30
 */
public interface BjxService {

    //获取百家姓简要列表
    ResponseData bjxList(String page);

    //根据id获取百家姓详情信息
    ResponseData bjxSrc(String id);

    //根据name获取百家姓详情信息
    ResponseData bjxSrc2(String name);
}