package com.mao.entity.species;

import lombok.Getter;
import lombok.Setter;

/**
 * 物种树结构，界门纲目科属种对应的上下级树形结构
 * 对应数据库表：tt_species_tree
 * @author mao by 11:01 2019/8/30
 */
@Getter
@Setter
public class SpeciesTree {

    private String id;          //主键
    private String pid;         //父类id
    private boolean isParent;   //是否是父节点
    private String name;        //名称
    private String pinyin;      //拼音
    private String url;         //无用字段

}