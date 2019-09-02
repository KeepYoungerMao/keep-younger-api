package com.mao.service.data;

import com.mao.entity.ResponseData;

/**
 * 书籍数据处理
 * @author mao by 11:33 2019/9/2
 */
public interface BookService {

    //获取书籍列表
    ResponseData bookList(String dynasty, String type, String page);

    //获取书籍详细信息
    ResponseData bookSrc(String id);

    //获取书籍所有章节
    ResponseData bookChapterList(String id);

    //获取章节详情
    ResponseData bookChapterSrc(String id);
}