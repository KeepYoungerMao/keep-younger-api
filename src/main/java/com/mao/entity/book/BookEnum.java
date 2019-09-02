package com.mao.entity.book;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 古书类型，分类
 * @author mao by 10:22 2019/9/2
 */
@Getter
@AllArgsConstructor
public enum BookEnum {

    error(-1),                  //错误类型
    all(0),                     //所有
    biography(1),               //传记
    swordsman(2),               //武侠
    historical_romance(3),      //历史演义
    military(4),                //军事
    historical_records(5),      //史记
    demon(6),                   //神魔
    geography(7),               //地理
    poem(8),                    //诗词
    notes(9),                   //笔记
    medicine(10),               //医学
    brief_biography(11),        //小传
    music(12),                  //音乐
    math(13),                   //算术
    storytelling(14),           //评书
    wiki(15),                   //百科
    buddhism(16),               //佛教
    geomantic(17),              //风水
    agriculture(18);            //农业

    private int type;            //分类

}