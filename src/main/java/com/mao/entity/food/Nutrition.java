package com.mao.entity.food;

import lombok.Getter;
import lombok.Setter;

/**
 * 食物原材料营养排行
 * @author mao by 11:46 2019/9/12
 */
@Getter
@Setter
public class Nutrition {

    private int fc_id;          //id主键
    private int fc_src_id;      //食物原材料id
    private String fc_p_name;   //食物原材料原名陈
    private String fc_name;     //名称
    private int fc_order;       //排名
    private float fc_value;     //营养数值
    private String fc_unit;     //单位

}