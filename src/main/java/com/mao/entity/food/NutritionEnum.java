package com.mao.entity.food;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author mao by 11:32 2019/9/12
 */
@Getter
@AllArgsConstructor
public enum NutritionEnum {

    heatQuantity(1),        //热量
    thiamine(2),            //硫胺素
    Ca(3),                  //钙
    protein(4),             //蛋白质
    riboflavin(5),          //核黄素
    Me(6),                  //镁
    fat(7),                 //脂肪
    niacin(8),              //烟酸
    Fe(9),                  //铁
    carbohydrate(10),       //碳水化合物
    vitaminC(11),           //维生素C
    Mn(12),                 //锰
    dietaryFiber(13),       //膳食纤维
    vitaminE(14),           //维生素E
    Zn(15),                 //锌
    vitaminA(16),           //维生素A
    cholesterol(17),        //胆固醇
    Cu(18),                 //铜
    carotene(19),           //胡萝卜素
    K(20),                  //钾
    P(21),                  //磷
    retinol(22),            //视黄醇
    Na(23),                 //钠
    Se(24);                 //硒

    private int kind;

}