package com.mao.entity.drug;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 药品（成品药）类别 类别
 * 药品归类，品种等级划分
 * @author mao by 15:00 2019/9/4
 */
@Getter
@AllArgsConstructor
public enum LbEnum {

    all(0),
    zby(1),         //中药保护品种一级
    zbe(2),         //中药保护品种二级
    bj(3),          //保健类药物、营养品、维生素等
    gy(4),          //国家基本药物目录
    wy(5),          //外用药物
    jl(6),          //非处方药物（甲类）
    yl(7),          //非处方药物（乙类）
    qt(8);          //其它

    private int type;

}