package com.mao.entity.food;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 食物原材料分类
 * @author mao by 10:49 2019/9/12
 */
@Getter
@AllArgsConstructor
public enum IngredientEnum {

    all(0),
    cereal(1),      //谷类
    starch(2),      //薯类淀粉
    beans(3),       //干豆类
    vegetable(4),   //蔬菜类
    fungi(5),       //菌藻类
    fruit(6),       //水果类
    nuts(7),        //坚果种子
    meat(8),        //畜肉类
    poultry(9),     //禽肉类
    milk(10),       //乳类
    egg(11),        //蛋类
    seafood(12),    //鱼虾蟹贝
    baby(13),       //婴幼儿类
    snack(14),      //小吃甜饼
    fastFood(15),   //速食
    softDrink(16),  //软饮料
    liquor(17),     //酒精饮料
    sugar(18),      //糖蜜饯类
    oil(19),        //油脂类
    seasoning(20),  //调味品类
    medicine(21),   //药食类
    other(22);      //其它

    private int type;

}