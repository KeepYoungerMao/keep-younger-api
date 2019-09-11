package com.mao.mapper.data;

import com.mao.entity.physique.Physique;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * 体质数据处理
 * @author mao by 10:45 2019/9/11
 */
@Repository
@Mapper
public interface PhysiqueMapper {

    //根据id查询体质详情信息
    Physique getPhysiqueById(@Param("id") int id);

}