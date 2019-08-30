package com.mao.service.his;

import com.mao.his.WeatherHandler;
import com.mao.his.pojo.Result;
import org.springframework.stereotype.Service;

/**
 * @author mao by 14:09 2019/8/30
 */
@Service
public class HisServiceHandler implements HisService {

    /**
     * 获取指定城市的天气数据
     * @param city 城市
     * @return 天气数据
     */
    @Override
    public Result getWeather(String city) {
        return WeatherHandler.getWeather(city);
    }

}