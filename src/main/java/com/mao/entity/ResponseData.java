package com.mao.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 统一返回信息类
 * @author mao by 17:25 2019/8/20
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ResponseData<T> {
    private int code;
    private T data;
}