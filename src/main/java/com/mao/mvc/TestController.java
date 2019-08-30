package com.mao.mvc;

import com.mao.entity.ResponseData;
import com.mao.service.ResponseServiceHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 测试
 * @author mao by 18:38 2019/8/19
 */
@RestController
@RequestMapping("api")
public class TestController {

    @Resource
    private ResponseServiceHandler responseServiceHandler;

    //测试请求
    @RequestMapping(value = "test", method = RequestMethod.GET)
    public ResponseData test(){
        return responseServiceHandler.ok("test id ok");
    }

}