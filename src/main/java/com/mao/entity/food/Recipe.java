package com.mao.entity.food;

import lombok.Getter;
import lombok.Setter;

/**
 * 食谱：tt_food_recipe
 * @author mao by 14:04 2019/9/12
 */
@Getter
@Setter
public class Recipe {

    private int fr_id;                  //id
    private String fr_name;             //菜谱名称
    private String fr_image;            //图片地址
    private String fr_b_image;          //大图片地址
    private String fr_author;           //菜谱作者
    private String fr_author_image;     //菜谱作者头像
    private String fr_intro;            //介绍
    private String fr_material;         //材料json
    private String fr_step;             //步骤json
    private String fr_tips;             //小贴士

}