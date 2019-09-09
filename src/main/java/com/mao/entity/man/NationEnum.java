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

    all(0);

    private int type;

}