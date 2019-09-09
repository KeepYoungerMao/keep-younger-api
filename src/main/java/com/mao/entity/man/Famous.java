package com.mao.entity.man;

import lombok.Getter;
import lombok.Setter;

/**
 * 历史人物：名人：tt_famous_man
 * @author mao by 16:08 2019/9/5
 */
@Getter
@Setter
public class Famous {

    private int id;             //id
    private String pre;         //首字母
    private String name;        //名称
    private String title;       //标题
    private String image;       //图片地址
    private String life;        //生涯
    private String nation;      //国籍
    private String intro;       //资料简介
    private String text;        //详情介绍

}