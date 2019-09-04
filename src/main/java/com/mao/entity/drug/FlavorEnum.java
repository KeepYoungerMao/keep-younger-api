package com.mao.entity.drug;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 性味类别
 * 五味
 * @author mao by 18:36 2019/9/3
 */
@Getter
@AllArgsConstructor
public enum FlavorEnum {

    all(null),
    sour("酸"),          //酸
    bitter("苦"),        //苦
    sweet("甘"),         //甘
    spicy("辛"),         //辛
    salt("咸");          //咸

    private String type;

}