package com.mao.ex;

import com.mao.entity.ResponseData;
import com.mao.entity.ResponseEnum;
import com.mao.service.ResponseServiceHandler;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * 异常统一处理器
 * @author mao by 10:08 2019/8/30
 */
@RestControllerAdvice
public class MaoExceptionHandler {

    @Resource
    private ResponseServiceHandler responseServiceHandler;

    /**
     * 404,500错误捕捉
     * @param request request
     * @param e exception
     * @return ResponseData
     */
    @ExceptionHandler(Exception.class)
    public ResponseData exceptionHandler(HttpServletRequest request, Exception e){
        if (e instanceof NoHandlerFoundException)
            return responseServiceHandler.error(ResponseEnum.NOT_FOUND,
                    "not found source: "+request.getRequestURI());
        else{
            e.printStackTrace();
            return responseServiceHandler.error(ResponseEnum.ERROR,
                    "server is busy. please try again later");
        }
    }

}