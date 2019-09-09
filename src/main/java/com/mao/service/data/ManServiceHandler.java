package com.mao.service.data;

import com.mao.entity.ResponseData;
import com.mao.entity.man.Famous;
import com.mao.entity.man.NationEnum;
import com.mao.entity.man.SimpleFamous;
import com.mao.mapper.data.ManMapper;
import com.mao.service.ResponseServiceHandler;
import com.mao.util.SU;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 人物数据处理
 * @author mao by 17:14 2019/9/5
 */
@Service
public class ManServiceHandler implements ManService {

    @Resource
    private ResponseServiceHandler responseServiceHandler;

    @Resource
    private ManMapper manMapper;

    /**
     * 根据首字母和国籍地区查询历史著名人物简要列表
     * @param pre 首字母
     * @param nation 国家或地区
     * @param center 时间点
     * @param page 页码
     * @return 简要历史人物列表
     */
    @Override
    public ResponseData famousList(String pre, String nation, String center, String page) {
        //pre
        if (!pre(pre))
            return responseServiceHandler.bad("invalid param: " + pre);
        if ("all".equals(pre)) pre = null;
        //nation
        NationEnum _nation = SU.getType(NationEnum.class, nation);
        if (null == _nation)
            return responseServiceHandler.bad("unknown type: " + nation);
        //center
        Integer _center = SU.getNumber(center);
        if (null == _center)
            return responseServiceHandler.bad("invalid param: " + center);
        //page
        int _page = SU.isNumber(page) ? Integer.parseInt(page) : 1;
        _page = _page == 1 ? 0 : (_page - 1)*10;
        List<SimpleFamous> list = manMapper.getFamousByType(pre,_nation.getType(),_center,_page);
        return responseServiceHandler.ok(list);
    }

    /**
     * 判断pre参数是否在A-Z之间
     * 特殊情况：all （所有类型）
     * @param pre 首字母参数
     * @return boolean
     */
    private boolean pre(String pre){
        if ("all".equals(pre))
            return true;
        if (pre.length() == 1){
            char c = pre.charAt(0);
            if (c >= 'A' && c <= 'Z')
                return true;
        }
        return false;
    }

    /**
     * 根据id查询历史人物详细信息
     * @param id id
     * @return 历史人物详细信息
     */
    @Override
    public ResponseData famousSrc(String id) {
        Integer _id = SU.getNumber(id);
        if (_id == null)
            return responseServiceHandler.bad("invalid param: "+ id);
        Famous famous = manMapper.getFamousById(_id);
        return responseServiceHandler.ok(famous);
    }
}