package com.mao.mapper.data;

import com.mao.entity.man.Famous;
import com.mao.entity.man.SimpleFamous;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 人物数据处理
 * @author mao by 17:27 2019/9/5
 */
@Repository
@Mapper
public interface ManMapper {

    //根据首字母和国家地区类型和时间查询历史人物简要列表
    List<SimpleFamous> getFamousByType(@Param("pre") String pre,
                                       @Param("nation") int nation,
                                       @Param("center") int center,
                                       @Param("page") int page);

    //根据id查询历史人物详细信息
    Famous getFamousById(@Param("id") int id);

}