package com.mao.entity.drug;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 归经分类
 * 心，肝，脾，肺，肾，三焦，小肠，胆，胃，大肠，膀胱，心包
 * @author mao by 18:39 2019/9/3
 */
@Getter
@AllArgsConstructor
public enum MeridianTropismEnum {

    all(null),
    heart("心"),                 //心
    liver("肝"),                 //肝
    spleen("脾"),                //脾
    lung("肺"),                  //肺
    kidney("肾"),                //肾
    trijiao("三焦"),             //三焦
    smallIntestine("小肠"),      //小肠
    gallbladder("胆"),           //胆
    stomach("胃"),               //胃
    largeIntestine("大肠"),      //大肠
    bladder("膀胱"),             //膀胱
    pericardium("心包");         //心包

    private String type;

}