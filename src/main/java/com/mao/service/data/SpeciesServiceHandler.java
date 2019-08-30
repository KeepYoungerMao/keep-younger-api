package com.mao.service.data;

import com.mao.entity.ResponseData;
import com.mao.entity.species.SpeciesListSrc;
import com.mao.entity.species.SpeciesTree;
import com.mao.mapper.data.SpeciesMapper;
import com.mao.service.ResponseServiceHandler;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 物种数据请求
 * @author mao by 11:10 2019/8/30
 */
@Service
public class SpeciesServiceHandler implements SpeciesService {

    @Resource
    private ResponseServiceHandler responseServiceHandler;

    @Resource
    private SpeciesMapper speciesMapper;

    /**
     * 获取物种树类信息
     * 传入id作为物种pid，查询种类下的子种类或物种列表
     * @param id pid
     * @return 物种树列表
     */
    public ResponseData speciesTrees(String id) {
        List<SpeciesTree> list = speciesMapper.getSpeciesTreeByPid(id);
        return responseServiceHandler.ok(list);
    }

    /**
     * 获取物种详细信息（列表信息）
     * 列表信息指：物种分类信息，分布信息
     * @param id 物种id
     * @return 物种详情
     */
    public ResponseData speciesListSrc(String id) {
        SpeciesListSrc src = speciesMapper.getSpeciesListSrcBySrcId(id);
        return responseServiceHandler.ok(src);
    }

}