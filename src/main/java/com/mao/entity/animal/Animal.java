package com.mao.entity.animal;

import lombok.Getter;
import lombok.Setter;

/**
 * 动物表： tt_animal
 * @author mao by 16:05 2019/8/30
 */
@Getter
@Setter
public class Animal {

    private int id;                 //id
    private String name;            //名称
    private int type;               //分类id
    private String type_name;       //分类名称
    private String picture;         //图片地址
    private String c_name;          //中文名称
    private String e_name;          //英文名称
    private String l_name;          //拉丁名称
    private String o_name;          //别名
    private String kingdom;         //界
    private String phylum;          //门
    private String sub_phylum;      //亚门
    private String p_class;         //纲
    private String sub_class;       //亚纲
    private String order;           //目
    private String sub_order;       //亚目
    private String family;          //科
    private String sub_family;      //亚科
    private String genus;           //属
    private String species;         //种
    private String sub_species;     //亚种
    private String distribute;      //分布
    private String field;           //域
    private String content;         //详细内容

}