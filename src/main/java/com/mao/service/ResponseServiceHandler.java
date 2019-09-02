package com.mao.service;

import com.mao.entity.ErrResponse;
import com.mao.entity.ResponseData;
import com.mao.entity.ResponseEnum;
import org.springframework.stereotype.Service;

/**
 * 返回类处理
 * @author mao by 14:11 2019/8/23
 */
@Service
public class ResponseServiceHandler {

    /**
     * 请求错误消息返回
     * @param msg 错误提示
     * @return ResponseData
     */
    public ResponseData bad(String msg){
        return ot(ResponseEnum.BAD_REQUEST,msg);
    }

    /**
     * 错误信息构建
     * @param type 错误类型
     * @param msg 错误信息
     * @return ResponseData
     */
    public ResponseData error(ResponseEnum type, String msg){
        return ot(type,new ErrResponse(msg));
    }

    /**
     * 成功信息构建
     * @param data 响应数据
     * @param <T> data类型
     * @return ResponseData
     */
    public <T> ResponseData ok(T data){
        return ot(ResponseEnum.SUCCESS,data);
    }

    /**
     * 成功信息构建
     * @param type 响应类型
     * @param data 数据
     * @param <T> data类型
     * @return ResponseData
     */
    private <T> ResponseData ot(ResponseEnum type, T data){
        return new ResponseData<>(type.getCode(), data);
    }

}