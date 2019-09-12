package com.mao.entity.food;

import lombok.Getter;
import lombok.Setter;

/**
 * 食物原材料简要列表
 * @author mao by 11:01 2019/9/12
 */
@Getter
@Setter
public class SimpleIngredient {

    private int fi_id;              //id
    private String fi_name;         //名称
    private String fi_alias;        //别名
    private String fi_s_image;      //小图片地址

}