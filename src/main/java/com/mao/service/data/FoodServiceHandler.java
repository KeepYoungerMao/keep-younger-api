package com.mao.service.data;

import com.alibaba.fastjson.JSON;
import com.mao.entity.ResponseData;
import com.mao.entity.food.*;
import com.mao.mapper.data.FoodMapper;
import com.mao.service.ResponseServiceHandler;
import com.mao.util.SU;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * 食物数据处理
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
            String intro = SU.addP(food.getFoo_intro());
            String[] yi = SU.isEmpty(food.getFoo_yi()) ?
                    new String[]{} : food.getFoo_yi().split(",");
            String[] ji = SU.isEmpty(food.getFoo_ji()) ?
                    new String[]{} : food.getFoo_ji().split(",");
            List<Collocation> collocations = foodMapper.getCollocationByFoodId(_id);
            FoodVo fv = new FoodVo(food.getFoo_id(),food.getFoo_name(),food.getFoo_image(),
                    food.getFoo_type(),food.getFoo_intro_list(),yi,ji,intro,collocations);
            return responseServiceHandler.ok(fv);
        }
        return responseServiceHandler.ok(null);
    }

    /**
     * 根据分类查询食物原材料简要列表
     * @param type 分类
     * @param page 页码
     * @return 食物原材料简要列表
     */
    @Override
    public ResponseData foodIngredientList(String type, String page) {
        IngredientEnum _type = SU.getType(IngredientEnum.class,type);
        if (null == _type)
            return responseServiceHandler.bad("unknown type: " + type);
        Integer _page = SU.getNumber(page);
        if (null == _page)
            return responseServiceHandler.bad("invalid param: " + page);
        _page = _page > 0 ? (_page == 1 ? 0 : (_page - 1)*10) : 0;
        List<SimpleIngredient> list = foodMapper.getFoodIngredientByType(_type.getType(),_page);
        return responseServiceHandler.ok(list);
    }

    /**
     * 根据id查询食物原材料详细信息
     * @param id id
     * @return 食物原材料详细信息
     */
    @Override
    public ResponseData foodIngredientSrc(String id) {
        Integer _id = SU.getNumber(id);
        if (null == _id)
            return responseServiceHandler.bad("invalid param: " + id);
        Ingredient ingredient = foodMapper.getFoodIngredientById(_id);
        return responseServiceHandler.ok(ingredient);
    }

    /**
     * 根据食物原材料类别查看指定营养类别排行
     * @param type 食物原材料类别
     * @param kind 食物营养类别
     * @return 食物原材料指定营养类别排行
     */
    @Override
    public ResponseData foodIngredientNutrition(String type, String kind) {
        IngredientEnum _type = SU.getType(IngredientEnum.class,type);
        if (null == _type)
            return responseServiceHandler.bad("unknown type: " + type);
        if (_type == IngredientEnum.all)
            return responseServiceHandler.bad("type 'all' cannot use here");
        NutritionEnum _kind = SU.getType(NutritionEnum.class,kind);
        if (null == _kind)
            return responseServiceHandler.bad("unknown type: " + kind);
        List<Nutrition> list = foodMapper.getFoodIngredientNutrition(_type.getType(),_kind.getKind());
        return responseServiceHandler.ok(list);
    }

    /**
     * 查询食谱简要列表
     * 4*3 排列
     * @param page 页码
     * @return 食谱简要列表
     */
    @Override
    public ResponseData foodRecipeList(String page) {
        Integer _page = SU.getNumber(page);
        if (null == _page)
            return responseServiceHandler.bad("invalid param: " + page);
        _page = _page > 0 ? (_page == 1 ? 0 : (_page - 1)*12) : 0;
        List<SimpleRecipe> list = foodMapper.getFoodRecipe(_page);
        return responseServiceHandler.ok(list);
    }

    /**
     * 根据id获取食谱详细信息
     * @param id id
     * @return 食谱详细信息
     */
    @Override
    public ResponseData foodRecipeSrc(String id) {
        Integer _id = SU.getNumber(id);
        if (null == _id)
            return responseServiceHandler.bad("invalid param: " + id);
        Recipe recipe = foodMapper.getFoodRecipeById(_id);
        String materialStr = recipe.getFr_material();
        String stepStr = recipe.getFr_step();
        List<Material> materials = SU.isNotEmpty(materialStr) ?
                JSON.parseArray(materialStr,Material.class) : new ArrayList<>();
        List<Step> steps = SU.isNotEmpty(stepStr) ?
                JSON.parseArray(stepStr,Step.class) : new ArrayList<>();
        RecipeVo rv = new RecipeVo(recipe.getFr_id(),recipe.getFr_name(),
                recipe.getFr_b_image(),recipe.getFr_author(),recipe.getFr_author_image(),
                recipe.getFr_intro(),materials,steps,recipe.getFr_tips());
        return responseServiceHandler.ok(rv);
    }

}