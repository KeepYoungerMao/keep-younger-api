package com.mao.entity.book;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 朝代类型
 * @author mao by 10:52 2019/9/2
 */
@Getter
@AllArgsConstructor
public enum BookDynastyEnum {

    error(-1),                  //错误类型
    all(0),                     //所有
    XIANQIN(1),                 //先秦
    QIN(2),                     //秦
    HAN(3),                     //汉
    SANGUO(4),                  //三国
    XDJIN(5),                   //（西东）晋
    NBCHAO(6),                  //南北朝
    SUI(7),                     //隋
    TANG(8),                    //唐
    WDSG(9),                    //五代十国
    SONG(10),                   //宋
    JIN(11),                    //金
    YUAN(12),                   //元
    MING(13),                   //明
    QING(14),                   //清
    JINDAI(15);                 //近代

    private int type;

}