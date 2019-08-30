package com.mao.service.his;

import com.mao.his.pojo.Result;

/**
 * @author mao by 14:08 2019/8/30
 */
public interface HisService {

    //获取指定城市的天气数据
    Result getWeather(String city);

}