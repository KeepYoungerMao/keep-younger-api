package com.mao.entity.food;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

/**
 * 食物详细信息展现
 * @author mao by 18:19 2019/9/10
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FoodVo {

    private int foo_id;                         //id
    private String foo_name;                    //食物名称
    private String foo_image;                   //食物图片地址
    private String foo_type;                    //食物类型
    private String foo_intro_list;              //列表介绍
    private String[] foo_yi;                    //宜 体制
    private String[] foo_ji;                    //忌 体制
    private String foo_intro;                   //详细介绍

    private List<Collocation> collocations;     //搭配

}