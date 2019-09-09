package com.mao.service.data;

import com.mao.entity.ResponseData;
import com.mao.entity.animal.Animal;
import com.mao.entity.animal.AnimalEnum;
import com.mao.entity.animal.SimpleAnimal;
import com.mao.mapper.data.AnimalMapper;
import com.mao.service.ResponseServiceHandler;
import com.mao.util.SU;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 动物大全数据处理
 * @author mao by 14:49 2019/8/30
 */
@Service
public class AnimalServiceHandler implements AnimalService {

    @Resource
    private ResponseServiceHandler responseServiceHandler;

    @Resource
    private AnimalMapper animalMapper;

    /**
     * 获取动物列表信息（简要列表）
     * @param type 分类
     * @param page 页码
     * @return 动物简要列表
     */
    @Override
    public ResponseData animalList(String type, String page) {
        AnimalEnum animalEnum = SU.getType(AnimalEnum.class,type);
        if (null == animalEnum)
            return responseServiceHandler.bad("unknown type: "+type);
        Integer _page = SU.getNumber(page);
        if (null == _page)
            return responseServiceHandler.bad("invalid param: " + page);
        _page = _page > 0 ? (_page == 1 ? 0 : (_page - 1)*10) : 0;
        List<SimpleAnimal> list = animalMapper.getAnimalByType(animalEnum.getType(),_page);
        return responseServiceHandler.ok(list);
    }

    /**
     * 获取动物详情信息
     * @param id id
     * @return 动物详情
     */
    @Override
    public ResponseData animalSrc(String id) {
        Integer _id = SU.getNumber(id);
        if (null == _id)
            return responseServiceHandler.bad("cannot get msg by: "+ id);
        Animal animal = animalMapper.getAnimalById(_id);
        animal.setContent(SU.addP(animal.getContent()));
        return responseServiceHandler.ok(animal);
    }
}