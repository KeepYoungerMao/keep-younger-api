package com.mao.mvc.data;

import com.mao.entity.ResponseData;
import com.mao.service.data.AnimalService;
import com.mao.service.data.BjxService;
import com.mao.service.data.SpeciesService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 数据请求
 * @author mao by 11:14 2019/8/30
 */
@RestController
@RequestMapping("api/data")
public class DataController {

    @Resource
    private SpeciesService speciesService;

    @Resource
    private AnimalService animalService;

    @Resource
    private BjxService bjxService;

    /**
     * 获取物种树类信息
     * @param id pid
     * @return 物种树列表
     */
    @RequestMapping(value = "species/tree/{id}", method = RequestMethod.GET)
    public ResponseData speciesTrees(@PathVariable(name = "id") String id){
        return speciesService.speciesTrees(id);
    }

    /**
     * 获取物种详细信息（列表信息）
     * @param id 物种id
     * @return 物种详情
     */
    @RequestMapping(value = "species/{id}", method = RequestMethod.GET)
    public ResponseData speciesListSrc(@PathVariable(name = "id") String id){
        return speciesService.speciesListSrc(id);
    }

    /**
     * 获取动物列表信息（简要列表）
     * @param type 分类
     * @param page 页码
     * @return 动物简要列表
     */
    @RequestMapping(value = "animal/{type}/list/{page}", method = RequestMethod.GET)
    public ResponseData animalList(@PathVariable(name = "type") String type,
                                   @PathVariable(name = "page") String page){
        return animalService.animalList(type,page);
    }

    /**
     * 获取动物详情信息
     * @param id id
     * @return 动物详情
     */
    @RequestMapping(value = "animal/{id}", method = RequestMethod.GET)
    public ResponseData animalSrc(@PathVariable(name = "id") String id){
        return animalService.animalSrc(id);
    }

    /**
     * 获取百家姓简要列表
     * @param page 页码
     * @return 百家姓简要列表
     */
    @RequestMapping(value = "bjx/list/{page}", method = RequestMethod.GET)
    public ResponseData bjxList(@PathVariable(name = "page") String page){
        return bjxService.bjxList(page);
    }

    /**
     * 获取百家姓详情信息（根据id查询）
     * @param id id
     * @return 百家姓详情信息
     */
    @RequestMapping(value = "bjx/{id}", method = RequestMethod.GET)
    public ResponseData bjxSrc(@PathVariable(name = "id") String id){
        return bjxService.bjxSrc(id);
    }

    /**
     * 获取百家姓详情信息（根据名称查询）
     * @param name name
     * @return 百家姓详情信息
     */
    @RequestMapping(value = "bjx/src/{name}", method = RequestMethod.GET)
    public ResponseData bjxSrc2(@PathVariable(name = "name") String name){
        return bjxService.bjxSrc2(name);
    }

}