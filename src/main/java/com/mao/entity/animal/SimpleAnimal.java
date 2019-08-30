package com.mao.entity.animal;

import lombok.Getter;
import lombok.Setter;

/**
 * 展示版动物列表
 * @author mao by 15:12 2019/8/30
 */
@Getter
@Setter
public class SimpleAnimal {

    private int id;             //id
    private String name;        //名称
    private String type_name;   //分类名称
    private String picture;     //图片地址

}