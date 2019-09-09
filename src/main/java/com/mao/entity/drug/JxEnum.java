package com.mao.entity.drug;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 药品（成品药）剂型 类别
 * 剂型，药品性状
 * @author mao by 15:00 2019/9/4
 */
@Getter
@AllArgsConstructor
public enum JxEnum {

    all(0),
    pills(1),               //丸剂
    plaster(2),             //乳膏剂
    lotion(3),              //冲洗剂
    powder(4),              //粉剂
    colloid(5),             //胶剂
    bulk(6),                //原料药
    solution(7),            //溶液剂
    mixture(8),             //合剂
    spray(9),               //雾剂
    liniment(10),           //擦涂剂
    powders(11),            //散剂    其实与粉剂同名
    tincture(12),           //曲剂
    suppository(13),        //栓剂
    injection(14),          //注射剂
    suspension(15),         //混悬剂
    drops(16),              //滴剂
    enema(17),              //灌肠剂
    compressionFormula(18), //熨剂
    tablet(19),             //片剂
    syrup(20),              //糖浆剂
    capsules(21),           //胶囊剂
    membrane(22),           //膜剂
    teas(23),               //茶剂
    patch(24),              //贴剂
    wine(25),               //酒剂
    pastille(26),           //锭剂
    granules(27),           //颗粒剂
    others(28);             //其他制剂

    private int type;

}