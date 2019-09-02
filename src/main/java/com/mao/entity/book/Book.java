package com.mao.entity.book;

import lombok.Getter;
import lombok.Setter;

/**
 * 书籍表 古书 tt_book
 * @author mao by 14:35 2019/9/2
 */
@Getter
@Setter
public class Book {

    private int boo_id;             //id
    private String boo_name;        //书籍名称
    private String boo_auth;        //作者
    private String boo_image;       //图片
    private String boo_intro;       //简介
    private String boo_type;        //书籍类型
    private String boo_dynasty;     //朝代

}