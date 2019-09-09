package com.mao.entity.man;

import lombok.Getter;
import lombok.Setter;

/**
 * 历史风云人物 简要列表
 * @author mao by 16:09 2019/9/5
 */
@Getter
@Setter
public class SimpleFamous {

    private int id;             //id
    private String name;        //名称
    private String title;       //标题
    private String image;       //图片地址
    private String life;        //生涯(?-?)

}