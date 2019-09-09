package com.mao.service.data;

import com.mao.entity.ResponseData;

/**
 * 人物数据处理
 * @author mao by 17:14 2019/9/5
 */
public interface ManService {

    //根据首字母和国籍地区查询历史著名人物简要列表
    ResponseData famousList(String pre, String nation, String center, String page);

    //根据id查询历史人物详细信息
    ResponseData famousSrc(String id);

}