package com.mao.entity.book;

import lombok.Getter;
import lombok.Setter;

/**
 * 章节，书籍章节 tt_chapter
 * @author mao by 14:49 2019/9/2
 */
@Getter
@Setter
public class Chapter {

    private int cha_id;         //id
    private int cha_cha_id;     //章节id
    private String cha_name;    //章节名称
    private int cha_book_id;    //书id
    private int cha_src_id;     //详情id

}