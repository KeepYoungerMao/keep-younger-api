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

    all(0);

    private int type;

}