package com.mao.entity.book;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

/**
 * 佛经列表数据
 * @author mao by 14:35 2019/9/3
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BuddhistData {

    private String type;                    //类型
    private List<SimpleBuddhist> list;      //类型数据

}