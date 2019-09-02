package com.mao.service.data;

import com.mao.entity.ResponseData;
import com.mao.entity.bjx.Surname;
import com.mao.mapper.data.BjxMapper;
import com.mao.service.ResponseServiceHandler;
import com.mao.util.SU;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 百家姓（姓氏）数据处理
 * @author mao by 16:20 2019/8/30
 */
@Service
public class BjxServiceHandler implements BjxService {

    @Resource
    private ResponseServiceHandler responseServiceHandler;

    @Resource
    private BjxMapper bjxMapper;

    /**
     * 获取百家姓简要列表
     * @param page 页码
     * @return 百家姓简要列表
     */
    @Override
    public ResponseData bjxList(String page) {
        if (!SU.isNumber(page))
            return responseServiceHandler.bad("invalid param: " + page);
        int _page = Integer.parseInt(page);
        _page = _page > 0 ? (_page == 1 ? 0 : (_page - 1)*10) : 0;
        List<Surname> list = bjxMapper.getSurname(_page);
        return responseServiceHandler.ok(list);
    }

    /**
     * 获取百家姓详情信息
     * @param id id
     * @return 百家姓详情信息
     */
    @Override
    public ResponseData bjxSrc(String id) {
        if (!SU.isNumber(id))
            return responseServiceHandler.bad("invalid param: " + id);
        int _id = Integer.parseInt(id);
        Surname surname = bjxMapper.getSurnameById(_id);
        return responseServiceHandler.ok(surname);
    }

    /**
     * 获取百家姓详情信息（根据名称查询）
     * @param name name
     * @return 百家姓详情信息
     */
    @Override
    public ResponseData bjxSrc2(String name) {
        Surname surname = bjxMapper.getSurnameByName(name);
        return responseServiceHandler.ok(surname);
    }
}