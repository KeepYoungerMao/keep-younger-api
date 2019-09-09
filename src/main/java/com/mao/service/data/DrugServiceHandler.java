package com.mao.service.data;

import com.mao.entity.ResponseData;
import com.mao.entity.drug.*;
import com.mao.mapper.data.DrugMapper;
import com.mao.service.ResponseServiceHandler;
import com.mao.util.SU;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 中草药、药品数据处理
 * @author mao by 10:38 2019/9/4
 */
@Service
public class DrugServiceHandler implements DrugService {

    @Resource
    private ResponseServiceHandler responseServiceHandler;

    @Resource
    private DrugMapper drugMapper;

    /**
     * 查询中草药简要列表
     * @param trait 四气
     * @param flavor 五味
     * @param tropism 归经
     * @param page 页码
     * @return 中草药简要列表
     */
    @Override
    public ResponseData crudeDrugList(String trait, String flavor, String tropism, String page) {
        TraitEnum _trait = SU.getType(TraitEnum.class, trait);
        if (null == _trait)
            return responseServiceHandler.bad("unknown type: " + trait);
        FlavorEnum _flavor = SU.getType(FlavorEnum.class, flavor);
        if (null == _flavor)
            return responseServiceHandler.bad("unknown type: " + flavor);
        MeridianTropismEnum _tropism = SU.getType(MeridianTropismEnum.class, tropism);
        if (null == _tropism)
            return responseServiceHandler.bad("unknown type: " + tropism);
        Integer _page = SU.getNumber(page);
        if (null == _page)
            return responseServiceHandler.bad("invalid param: " + page);
        _page = _page > 0 ? (_page == 1 ? 0 : (_page - 1)*10) : 0;
        String type;
        if (_trait == TraitEnum.all && _flavor == FlavorEnum.all
                && _tropism == MeridianTropismEnum.all){
            type = null;
        } else {
            type = "%";
            if (_trait != TraitEnum.all)
                type += _trait.getType() + "%";
            if (_flavor != FlavorEnum.all)
                type += _flavor.getType() + "%";
            if (_tropism != MeridianTropismEnum.all)
                type += _tropism.getType() + "%";
        }
        List<SimpleCrudeDrug> list = drugMapper.getCrudeDrugByType(type,_page);
        return responseServiceHandler.ok(list);
    }

    /**
     * 查询中草药详细信息
     * @param id id
     * @return 中草药详细信息
     */
    @Override
    public ResponseData crudeDrugSrc(String id) {
        Integer _id = SU.getNumber(id);
        if (null == _id)
            return responseServiceHandler.bad("invalid param: " + id);
        CrudeDrug crudeDrug = drugMapper.getCrudeDrugById(_id);
        return responseServiceHandler.ok(crudeDrug);
    }

    /**
     * 获取成品药简要列表
     * @param fl 分类 科室或用处划分
     * @param jx 剂型 药品性状
     * @param lb 类别 品种和等级划分
     * @param page 页码
     * @return 成品药简要列表
     */
    @Override
    public ResponseData drugList(String fl, String jx, String lb, String page) {
        FlEnum _fl = SU.getType(FlEnum.class, fl);
        if (null == _fl)
            return responseServiceHandler.bad("unknown type: " + fl);
        JxEnum _jx = SU.getType(JxEnum.class, jx);
        if (null == _jx)
            return responseServiceHandler.bad("unknown type: " + jx);
        LbEnum _lb = SU.getType(LbEnum.class, lb);
        if (null == _lb)
            return responseServiceHandler.bad("unknown type: " + lb);
        Integer _page = SU.getNumber(page);
        if (_page == null)
            return responseServiceHandler.bad("invalid param: " + page);
        _page = _page > 0 ? (_page == 1 ? 0 : (_page - 1)*10) : 0;
        List<Drug> list = drugMapper.getDrugByType(_fl.getType(),_jx.getType(),_lb.getType(),_page);
        return responseServiceHandler.ok(list);
    }

    /**
     * 获取成品药详情信息
     * @param id id
     * @return 成品药详情信息
     */
    @Override
    public ResponseData drugSrc(String id) {
        Integer _id = SU.getNumber(id);
        if (_id == null)
            return responseServiceHandler.bad("invalid id: " + id);
        DrugSrc drugSrc = drugMapper.getDrugSrcById(_id);
        return responseServiceHandler.ok(drugSrc);
    }
}