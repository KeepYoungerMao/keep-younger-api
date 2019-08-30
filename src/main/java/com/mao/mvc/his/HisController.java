package com.mao.mvc.his;

import com.mao.his.pojo.Result;
import com.mao.service.his.HisService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 外接数据转发
 * @author mao by 14:07 2019/8/30
 */
@RestController
@RequestMapping("api/his")
public class HisController {

    @Resource
    private HisService hisService;

    /**
     * 获取指定城市的天气数据
     * @param city 城市
     * @return 天气数据
     */
    @RequestMapping("weather/{city}")
    public Result weather(@PathVariable(name = "city") String city){
        return hisService.getWeather(city);
    }

}