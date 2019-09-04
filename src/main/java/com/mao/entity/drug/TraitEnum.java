package com.mao.entity.drug;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 性味类别
 * 四气：温热寒凉平
 * @author mao by 18:41 2019/9/3
 */
@Getter
@AllArgsConstructor
public enum TraitEnum {

    all(null),
    warm("温"),       //温
    hot("热"),        //热
    frosty("寒"),     //寒
    cold("凉"),       //凉
    calm("平");       //平

    private String type;

}