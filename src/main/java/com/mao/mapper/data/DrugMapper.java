package com.mao.mapper.data;

import com.mao.entity.drug.CrudeDrug;
import com.mao.entity.drug.Drug;
import com.mao.entity.drug.DrugSrc;
import com.mao.entity.drug.SimpleCrudeDrug;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 中草药、药品数据处理
 * @author mao by 11:20 2019/9/4
 */
@Repository
@Mapper
public interface DrugMapper {

    //根据四气五味查询中草药简要列表
    List<SimpleCrudeDrug> getCrudeDrugByType(@Param("type") String type, @Param("page") int page);

    //根据id查询中草药详细信息
    CrudeDrug getCrudeDrugById(@Param("id") int id);

    //根据分类类型查询成品药简要列表
    List<Drug> getDrugByType(@Param("fl") int fl, @Param("jx") int jx,
                             @Param("lb") int lb, @Param("page") int page);

    //根据id查询成品药详情
    DrugSrc getDrugSrcById(@Param("id") int id);

}