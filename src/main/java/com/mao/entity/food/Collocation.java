package com.mao.entity.food;

import lombok.Getter;
import lombok.Setter;

/**
 * 食物搭配
 * @author mao by 16:48 2019/9/10
 */
@Getter
@Setter
public class Collocation {

    private int ref_id;             //搭配的食物id
    private String ref_name;        //搭配的食物名称
    private String ref_image;       //搭配的食物图片地址
    private int yj;                 //宜：1 ； 忌： 0
    private String intro;           //搭配介绍

}