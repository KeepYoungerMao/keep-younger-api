package com.mao.entity.food;

import lombok.Getter;
import lombok.Setter;

/**
 * 食物简要列表
 * @author mao by 16:23 2019/9/10
 */
@Getter
@Setter
public class SimpleFood {

    private int foo_id;                 //id
    private String foo_name;            //名称
    private String foo_image;           //图片地址
    private String foo_type;            //类型
    private String foo_intro_pre;       //简介

}