package com.mao.service.data;

import com.mao.entity.ResponseData;
import com.mao.entity.physique.Physique;
import com.mao.mapper.data.PhysiqueMapper;
import com.mao.service.ResponseServiceHandler;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 体质数据处理
 * @author mao by 10:33 2019/9/11
 */
@Service
public class PhysiqueServiceHandler implements PhysiqueService {

    @Resource
    private ResponseServiceHandler responseServiceHandler;

    @Resource
    private PhysiqueMapper physiqueMapper;

    /**
     * 根据名称查询体质详情
     * @param name 名称
     * @return 体质
     */
    @Override
    public ResponseData physique(String name) {
        int id = getPhysique(name);
        if (0 == id)
            return responseServiceHandler.bad("unknown name: " + name);
        Physique physique = physiqueMapper.getPhysiqueById(id);
        return responseServiceHandler.ok(physique);
    }

    private int getPhysique(String name){
        switch (name){
            case "平和质": return 1;
            case "气虚质": return 2;
            case "阳虚质": return 3;
            case "阴虚质": return 4;
            case "痰湿质": return 5;
            case "湿热质": return 6;
            case "血瘀质": return 7;
            case "气郁质": return 8;
            case "特禀质": return 9;
            default: return 0;
        }
    }

}