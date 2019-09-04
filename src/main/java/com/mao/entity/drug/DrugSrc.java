package com.mao.entity.drug;

import lombok.Getter;
import lombok.Setter;

/**
 * 成品药详情表： tt_drug_src
 * @author mao by 16:00 2019/9/4
 */
@Getter
@Setter
public class DrugSrc {

    private int dru_id;         //id
    private String image;       //图片地址
    private String title;       //标题
    private String sp_name;     //商品名称
    private String ty_name;     //通用名称
    private String yw_name;     //英文名称
    private String jx;          //剂型
    private String gg;          //规格
    private String lb;          //类别
    private String pzwh;        //批准文号
    private String zc;          //贮藏
    private String yxq;         //有效期
    private String cf;          //成份
    private String syz;         //适应症
    private String yfyl;        //用法用量
    private String blfy;        //不良反应
    private String jj;          //禁忌
    private String zysx;        //注意事项
    private String etyy;        //儿童用药
    private String yfyy;        //孕妇用药
    private String lryy;        //老人用药
    private String xhzy;        //药物相互作用
    private String ylzy;        //药理作用
    private String xdrq;        //说明书修订日期
    private String qymc;        //企业名称
    private String qyjc;        //企业简称
    private String scdz;        //生产地址
    private String lxdh;        //联系电话

}