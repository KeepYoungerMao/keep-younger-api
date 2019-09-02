package com.mao.entity.book;

import lombok.Getter;
import lombok.Setter;

/**
 * 书籍简要列表
 * @author mao by 11:30 2019/9/2
 */
@Getter
@Setter
public class SimpleBook {

    private int boo_id;             //id
    private String boo_name;        //名称
    private String boo_auth;        //作者
    private String boo_s_image;     //缩略图
    private String boo_dynasty;     //朝代

}