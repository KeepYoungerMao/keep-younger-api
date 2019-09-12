package com.mao.entity.food;

import lombok.Getter;
import lombok.Setter;

/**
 * 食物原材料： tt_food_ingredient
 * @author mao by 11:11 2019/9/12
 */
@Getter
@Setter
public class Ingredient {

    private int fi_id;              //id
    private String fi_name;         //名称
    private String fi_alias;        //别名
    private String fi_b_image;      //大图片地址
    private String fi_usage;        //平时用量
    private String fi_intro;        //详情介绍

}