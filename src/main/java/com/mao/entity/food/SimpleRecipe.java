package com.mao.entity.food;

import lombok.Getter;
import lombok.Setter;

/**
 * 食谱简要列表
 * @author mao by 14:29 2019/9/12
 */
@Getter
@Setter
public class SimpleRecipe {

    private int fr_id;                  //id
    private String fr_name;             //菜谱名称
    private String fr_image;            //图片地址
    private String fr_author;           //菜谱作者
    private String fr_author_image;     //菜谱作者头像

}