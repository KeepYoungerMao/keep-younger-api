package com.mao.mvc.data;

import com.mao.entity.ResponseData;
import com.mao.service.data.*;
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

    @Resource
    private BookService bookService;

    @Resource
    private DrugService drugService;

    @Resource
    private ManService manService;

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

    /**
     * 获取书籍列表
     * @param dynasty 朝代
     * @param type 类型
     * @param page 页码
     * @return 书籍列表简要信息
     */
    @RequestMapping(value = "book/{dynasty}-{type}/{page}", method = RequestMethod.GET)
    public ResponseData bookList(@PathVariable(name = "dynasty") String dynasty,
                                 @PathVariable(name = "type") String type,
                                 @PathVariable(name = "page") String page){
        return bookService.bookList(dynasty,type,page);
    }

    /**
     * 查询书籍详情信息
     * @param id id
     * @return 书籍详细信息
     */
    @RequestMapping(value = "book/{id}", method = RequestMethod.GET)
    public ResponseData bookSrc(@PathVariable(name = "id") String id){
        return bookService.bookSrc(id);
    }

    /**
     * 获取书籍的所有章节，书籍章节列表不做分页
     * @param id 书籍id
     * @return 章节列表
     */
    @RequestMapping(value = "book/{id}/chapter", method = RequestMethod.GET)
    public ResponseData bookChapterList(@PathVariable(name = "id") String id){
        return bookService.bookChapterList(id);
    }

    /**
     * 查询章节详细信息
     * @param id 章节id
     * @return 章节详细信息
     */
    @RequestMapping(value = "book/chapter/{id}", method = RequestMethod.GET)
    public ResponseData bookChapterSrc(@PathVariable(name = "id") String id){
        return bookService.bookChapterSrc(id);
    }

    /**
     * 获取所有佛经列表
     * @return 佛经列表
     */
    @RequestMapping(value = "book/buddhist", method = RequestMethod.GET)
    public ResponseData buddhistList(){
        return bookService.buddhistList();
    }

    /**
     * 查询佛经详情信息
     * @param id id
     * @return 佛经详情信息
     */
    @RequestMapping(value = "book/buddhist/{id}", method = RequestMethod.GET)
    public ResponseData buddhistSrc(@PathVariable(name = "id") String id){
        return bookService.buddhistSrc(id);
    }

    /**
     * 查询佛经章节详情信息
     * @param id id
     * @return 佛经章节详情信息
     */
    @RequestMapping(value = "book/buddhist/chapter/{id}", method = RequestMethod.GET)
    public ResponseData buddhistChapterSrc(@PathVariable(name = "id") String id){
        return bookService.buddhistChapterSrc(id);
    }

    /**
     * 查询中草药简要列表
     * @param trait 四气
     * @param flavor 五味
     * @param tropism 归经
     * @param page 页码
     * @return 中草药简要列表
     */
    @RequestMapping(value = "crudeDrug/{trait}-{flavor}-{tropism}/{page}",
            method = RequestMethod.GET)
    public ResponseData crudeDrugList(@PathVariable(name = "trait") String trait,
                                      @PathVariable(name = "flavor") String flavor,
                                      @PathVariable(name = "tropism") String tropism,
                                      @PathVariable(name = "page") String page){
        return drugService.crudeDrugList(trait,flavor,tropism,page);
    }

    /**
     * 查询中草药详细信息
     * @param id id
     * @return 中草药详细信息
     */
    @RequestMapping(value = "crudeDrug/{id}", method = RequestMethod.GET)
    public ResponseData crudeDrugSrc(@PathVariable(name = "id") String id){
        return drugService.crudeDrugSrc(id);
    }

    /**
     * 获取成品药简要列表
     * @param fl 分类 科室或用处划分
     * @param jx 剂型 药品性状
     * @param lb 类别 品种和等级划分
     * @param page 页码
     * @return 成品药简要列表
     */
    @RequestMapping(value = "drug/{fl}-{jx}-{lb}/{page}", method = RequestMethod.GET)
    public ResponseData drugList(@PathVariable(name = "fl") String fl,
                                 @PathVariable(name = "jx") String jx,
                                 @PathVariable(name = "lb") String lb,
                                 @PathVariable(name = "page") String page){
        return drugService.drugList(fl,jx,lb,page);
    }

    /**
     * 获取成品药详情信息
     * @param id id
     * @return 成品药详情信息
     */
    @RequestMapping(value = "drug/{id}", method = RequestMethod.GET)
    public ResponseData drugSrc(@PathVariable(name = "id") String id){
        return drugService.drugSrc(id);
    }

    /**
     * 根据首字母和国籍地区查询历史著名人物简要列表
     * @param pre 首字母
     * @param nation 国家或地区
     * @param center 时间点
     * @param page 页码
     * @return 简要历史人物列表
     */
    @RequestMapping(value = "man/famous/{pre}_{nation}_{center}/{page}", method = RequestMethod.GET)
    public ResponseData famousList(@PathVariable(name = "pre") String pre,
                                   @PathVariable(name = "nation") String nation,
                                   @PathVariable(name = "center") String center,
                                   @PathVariable(name = "page") String page){
        return manService.famousList(pre,nation,center,page);
    }

    /**
     * 根据id查询历史人物详细信息
     * @param id id
     * @return 历史人物详细信息
     */
    @RequestMapping(value = "man/famous/{id}", method = RequestMethod.GET)
    public ResponseData famousSrc(@PathVariable(name = "id") String id){
        return manService.famousSrc(id);
    }

}