package com.mao.entity.drug;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 药品（成品药）分类 类别
 * 科室及用处
 * @author mao by 14:59 2019/9/4
 */
@Getter
@AllArgsConstructor
public enum FlEnum {

    all(0),             //所有
    gmfr(1),            //感冒发热
    pf(2),              //皮肤用药
    cw(3),              //肠胃用药
    wg(4),              //五官用药
    hxxt(5),            //呼吸系统类
    jtcb(6),            //家庭常备
    nk(7),              //男科
    fk(8),              //妇科
    ek(9),              //儿科
    wss(10),            //维生素及营养
    xnxg(11),           //心脑血管
    gdy(12),            //肝胆胰用药
    sb(13),             //肾病
    nfm(14),            //内分泌失常
    sj(15),             //神经/精神科
    zl(16),             //肿瘤科
    fsmy(17),           //风湿免疫科
    kjsc(18),           //抗寄生虫
    sdjz(19),           //水电解质及酸碱平衡
    xy(20),             //血液疾病类
    kjh(21),            //抗结核及麻风用药
    xb(22);             //性病用药

    private int type;

}