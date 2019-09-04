package com.mao.entity.drug;

import lombok.Getter;
import lombok.Setter;

/**
 * 中草药简单数据列表
 * @author mao by 18:33 2019/9/3
 */
@Getter
@Setter
public class SimpleCrudeDrug {

    private int id;                 //id
    private String title;           //标题
    private String intro;           //简介
    private String image;           //图片地址
    private String name;            //中草药名称
    private String channel_tropism; //四气五味、归经

}