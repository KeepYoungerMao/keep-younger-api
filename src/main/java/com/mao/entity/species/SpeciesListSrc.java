package com.mao.entity.species;

import lombok.Getter;
import lombok.Setter;

/**
 * 物种列表详情，包含物种与生物分类关系、分布区域等
 * 对应数据库表：tt_species_list_src
 * @author mao by 11:03 2019/8/30
 */
@Getter
@Setter
public class SpeciesListSrc {

    private int id;                     //主键
    private String src_id;              //物种树id
    private String j_id;                //界
    private String j_name;              //界
    private String m_id;                //门
    private String m_name;              //门
    private String g_id;                //纲
    private String g_name;              //纲
    private String mu_id;               //目
    private String mu_name;             //目
    private String k_id;                //科
    private String k_name;              //科
    private String s_id;                //属
    private String s_name;              //属
    private String z_id;                //种
    private String z_name;              //种
    private String accepted_name;       //接受的学名
    private String chinese_name;        //中文名
    private String synonym_name;        //异名
    private String other_name;          //别名
    private String type;                //物种树
    private String distribute;          //分布

}