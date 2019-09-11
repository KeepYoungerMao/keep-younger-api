package com.mao.entity.physique;

import lombok.Getter;
import lombok.Setter;

/**
 * 体质详情介绍：tt_physique
 * @author mao by 10:19 2019/9/11
 */
@Getter
@Setter
public class Physique {

    private int id;                 //id
    private String name;            //体制名称
    private String character;       //总体特征
    private String performance;     //常见表现
    private String disease;         //易发疾病
    private String adapt;           //对外界环境适应能力
    private String principle;       //调整原则
    private String diet_adjust;     //饮食调整
    private String drug_adjust;     //中药调整
    private String life_adjust;     //体质养生
    private String nourish;         //养生推荐
    private String diet;            //药膳指导
    private String drug;            //推荐药材

}