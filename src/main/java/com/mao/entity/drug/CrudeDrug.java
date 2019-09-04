package com.mao.entity.drug;

import lombok.Getter;
import lombok.Setter;

/**
 * 中草药详细信息表：tt_crude_drug
 * @author mao by 11:47 2019/9/4
 */
@Getter
@Setter
public class CrudeDrug {

    private int id;                             //id
    private String title;                       //标题
    private String intro;                       //简介
    private String image;                       //图片地址
    private String name;                        //中草药名称（中文名）
    private String alias;                       //别名
    private String en_name;                     //英文名
    private String medicinal_part;              //药用部位
    private String plant_shape;                 //植物形态
    private String origin_distribution;         //产地分布
    private String collect_process;             //收集加工
    private String trait;                       //药材性状
    private String channel_tropism;             //性味归经
    private String efficacy;                    //功效与作用
    private String clinical_practice;           //临床研究
    private String pharmacological_research;    //药理研究
    private String chemical_composition;        //化学成分
    private String use_taboo;                   //使用禁忌
    private String compatibility_prescription;  //药方配伍

}