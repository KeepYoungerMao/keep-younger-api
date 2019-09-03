package com.mao.entity.book;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 佛经列表简单数据
 * @author mao by 14:36 2019/9/3
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SimpleBuddhist {

    private int bs_id;          //id
    private String bs_name;     //佛经名称
    private String bs_image;    //图片地址

}