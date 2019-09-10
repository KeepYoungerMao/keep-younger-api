package com.mao.entity.food;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 食物类型
 * @author mao by 16:10 2019/9/10
 */
@Getter
@AllArgsConstructor
public enum FoodEnum {

    all(0),                 //所有类型，不分类型
    vegetable(1),           //蔬菜
    fruit(2),               //水果
    starch(3),              //薯类淀粉
    fungi(4),               //菌藻类
    animalMeat(5),          //畜肉类
    poultry(6),             //禽肉类
    seafood(7),             //鱼虾蟹贝
    egg(8),                 //蛋类
    frumentum(9),           //谷类
    beans(10),              //豆类
    nuts(11),               //坚果类
    milk(12),               //乳类
    drinks(13),             //饮料
    others(14);             //其他

    private int type;

}