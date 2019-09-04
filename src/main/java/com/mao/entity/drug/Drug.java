package com.mao.entity.drug;

import lombok.Getter;
import lombok.Setter;

/**
 * 药品 成品药： tt_drug
 * @author mao by 15:16 2019/9/4
 */
@Getter
@Setter
public class Drug {

    private int dru_id;             //id
    private String dru_name;        //名称
    private String dru_image;       //图片地址
    private String dru_intro;       //简介
    private String dru_factory;     //生产厂家

}