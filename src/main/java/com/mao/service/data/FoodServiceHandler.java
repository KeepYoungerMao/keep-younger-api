package com.mao.service.data;

import com.mao.entity.ResponseData;
import com.mao.entity.food.Collocation;
import com.mao.entity.food.Food;
import com.mao.entity.food.FoodEnum;
import com.mao.entity.food.SimpleFood;
import com.mao.mapper.data.FoodMapper;
import com.mao.service.ResponseServiceHandler;
import com.mao.util.SU;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author mao by 16:29 2019/9/10
 */
@Service
public class FoodServiceHandler implements FoodService {

    @Resource
    private ResponseServiceHandler responseServiceHandler;

    @Resource
    private FoodMapper foodMapper;

    /**
     * 根据类型查询食物简要列表
     * @param type 类型
     * @param page 页码
     * @return 食物简要列表
     */
    @Override
    public ResponseData foodList(String type, String page) {
        FoodEnum _type = SU.getType(FoodEnum.class,type);
        if (null == _type)
            return responseServiceHandler.bad("unknown type: " + type);
        Integer _page = SU.getNumber(page);
        if (null == _page)
            return responseServiceHandler.bad("invalid param: " + page);
        _page = _page > 0 ? (_page == 1 ? 0 : (_page - 1)*10) : 0;
        List<SimpleFood> list = foodMapper.getFoodByType(_type.getType(),_page);
        return responseServiceHandler.ok(list);
    }

    /**
     * 根据id查询食物详情信息
     * 增加 p 标签 ， 增加宜忌列表
     * @param id id
     * @return 食物详情信息
     */
    @Override
    public ResponseData foodSrc(String id) {
        Integer _id = SU.getNumber(id);
        if (null == _id)
            return responseServiceHandler.bad("invalid param: " + id);
        Food food = foodMapper.getFoodById(_id);
        if (null != food){
            food.setFoo_intro(SU.addP(food.getFoo_intro()));
            List<Collocation> collocations = foodMapper.getCollocationByFoodId(_id);
            food.setCollocations(collocations);
        }
        return responseServiceHandler.ok(food);
    }

}