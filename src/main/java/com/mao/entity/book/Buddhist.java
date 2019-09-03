package com.mao.entity.book;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * 佛经详情列表
 * @author mao by 14:43 2019/9/3
 */
@Getter
@Setter
public class Buddhist {

    private int bs_id;          //id
    private String bs_name;     //佛经名称
    private String bs_image;    //图片地址
    private String bs_intro;    //简介
    private String bs_type;     //佛经类型

    private List<BuddhistChapter> chapter;      //章节列表

}