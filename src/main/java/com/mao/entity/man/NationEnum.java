package com.mao.entity.man;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 国家或地区分类
 * 国外统称 国外
 * @author mao by 17:17 2019/9/5
 */
@Getter
@AllArgsConstructor
public enum NationEnum {

    all(0),             //所有分类，不作分类
    filmLegend(1),      //影视、传说
    china(2),           //中国
    japan(3),           //日本
    america(4),         //美国
    england(5),         //英国
    germany(6),         //德国、德意志帝国
    france(7),          //法国
    italy(8),           //意大利
    russia(9),          //俄罗斯
    india(10),          //印度
    mongolia(11),       //蒙古、蒙古汗国
    austria(12),        //奥地利
    rome(13),           //古罗马
    spain(14),          //西班牙
    korea(15),          //朝鲜
    southKorea(16),     //韩国
    greek(17),          //古希腊
    vietnam(18),        //越南
    other(19);          //其它国家或地区分类

    private int type;

}