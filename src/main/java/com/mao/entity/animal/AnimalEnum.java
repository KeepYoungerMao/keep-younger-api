package com.mao.entity.animal;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 动物类型
 * @author mao by 14:42 2019/8/30
 */
@Getter
@AllArgsConstructor
public enum AnimalEnum {

    error(-1),           //错误类型
    all(0),             //全部类型
    reptiles(1),        //爬行类
    invertebrates(2),   //无脊椎类
    mammals(3),         //哺乳类
    amphibians(4),      //两栖类
    fish(5),            //鱼类
    bird(6);            //鸟类

    private int type;

}