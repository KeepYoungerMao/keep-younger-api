package com.mao.entity.food;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

/**
 * 食谱数据：用于展示
 * @author mao by 14:52 2019/9/12
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RecipeVo {

    private int fr_id;                  //id
    private String fr_name;             //菜谱名称
    private String fr_b_image;          //大图片地址
    private String fr_author;           //菜谱作者
    private String fr_author_image;     //菜谱作者头像
    private String fr_intro;            //介绍
    private List<Material> materials;   //材料
    private List<Step> steps;           //步骤
    private String fr_tips;             //小贴士

}