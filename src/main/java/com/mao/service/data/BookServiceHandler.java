package com.mao.service.data;

import com.mao.entity.ResponseData;
import com.mao.entity.book.*;
import com.mao.mapper.data.BookMapper;
import com.mao.service.ResponseServiceHandler;
import com.mao.util.SU;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * 书籍数据处理
 * @author mao by 11:33 2019/9/2
 */
@Service
public class BookServiceHandler implements BookService {

    @Resource
    private ResponseServiceHandler responseServiceHandler;

    @Resource
    private BookMapper bookMapper;

    /**
     * 获取书籍列表
     * @param dynasty 朝代
     * @param type 类型
     * @param page 页码
     * @return 书籍列表简要信息
     */
    @Override
    public ResponseData bookList(String dynasty, String type, String page) {
        BookDynastyEnum dynastyEnum = getDynasty(dynasty);
        if (dynastyEnum == BookDynastyEnum.error)
            return responseServiceHandler.bad("invalid param: " + dynasty);
        BookEnum bookEnum = getType(type);
        if (bookEnum == BookEnum.error)
            return responseServiceHandler.bad("invalid param: " + type);
        if (!SU.isNumber(page))
            return responseServiceHandler.bad("invalid param: " + page);
        int _page = Integer.parseInt(page);
        _page = _page > 0 ? (_page == 1 ? 0 : (_page - 1)*10) : 0;
        List<SimpleBook> list = bookMapper.getBookList(
                dynastyEnum.getType(), bookEnum.getType(), _page);
        return responseServiceHandler.ok(list);
    }

    /**
     * 获取书籍朝代
     * @param dynasty 朝代字符串
     * @return BookDynastyEnum
     */
    private BookDynastyEnum getDynasty(String dynasty){
        try {
            return BookDynastyEnum.valueOf(dynasty);
        } catch (IllegalArgumentException e) {
            return BookDynastyEnum.error;
        }
    }

    /**
     * 获取书籍类型
     * @param type 类型字符串
     * @return BookEnum
     */
    private BookEnum getType(String type){
        try {
            return BookEnum.valueOf(type);
        } catch (IllegalArgumentException e) {
            return BookEnum.error;
        }
    }

    /**
     * 查询书籍详情信息
     * @param id id
     * @return 书籍详细信息
     */
    @Override
    public ResponseData bookSrc(String id) {
        if (!SU.isNumber(id))
            return responseServiceHandler.bad("invalid param: " + id);
        int _id = Integer.parseInt(id);
        Book book = bookMapper.getBookById(_id);
        return responseServiceHandler.ok(book);
    }

    /**
     * 获取书籍的所有章节，书籍章节列表不做分页
     * @param id 书籍id
     * @return 章节列表
     */
    @Override
    public ResponseData bookChapterList(String id) {
        if (!SU.isNumber(id))
            return responseServiceHandler.bad("invalid param: " + id);
        int _id = Integer.parseInt(id);
        List<Chapter> list = bookMapper.getChapterByBookId(_id);
        return responseServiceHandler.ok(list);
    }

    /**
     * 查询章节详细信息
     * @param id 章节id
     * @return 章节详细信息
     */
    @Override
    public ResponseData bookChapterSrc(String id) {
        if (!SU.isNumber(id))
            return responseServiceHandler.bad("invalid param: " + id);
        int _id = Integer.parseInt(id);
        String text = bookMapper.getChapterSrcById(_id);
        return responseServiceHandler.ok(SU.addP(text));
    }

    /**
     * 获取所有佛经列表
     * @return 佛经列表
     */
    @Override
    public ResponseData buddhistList() {
        List<Buddhist> list = bookMapper.getBuddhist();
        List<BuddhistData> data = new ArrayList<>();
        for (Buddhist buddhist : list) {
            addBuddhist(data,buddhist);
        }
        return responseServiceHandler.ok(data);
    }

    /**
     * 给佛经分类
     * @param data 分类后的数据接收类
     * @param buddhist 佛经
     */
    private void addBuddhist(List<BuddhistData> data, Buddhist buddhist){
        boolean add = true;
        SimpleBuddhist sb = new SimpleBuddhist(buddhist.getBs_id(),
                buddhist.getBs_name(),buddhist.getBs_image());
        for (BuddhistData bd : data) {
            if (bd.getType().equals(buddhist.getBs_type())){
                bd.getList().add(sb);
                add = false;
                break;
            }
        }
        if (add){
            List<SimpleBuddhist> list = new ArrayList<>();
            list.add(sb);
            data.add(new BuddhistData(buddhist.getBs_type(),list));
        }
    }

    /**
     * 查询佛经详情信息
     * @param id id
     * @return 佛经详情信息
     */
    @Override
    public ResponseData buddhistSrc(String id) {
        if (!SU.isNumber(id))
            return responseServiceHandler.bad("invalid param: " + id);
        int _id = Integer.parseInt(id);
        Buddhist buddhist = bookMapper.getBuddhistById(_id);
        List<BuddhistChapter> list = bookMapper.getBuddhistChapterBySId(_id);
        buddhist.setChapter(list);
        return responseServiceHandler.ok(buddhist);
    }

    /**
     * 查询佛经章节详情信息
     * @param id id
     * @return 佛经章节详情信息
     */
    @Override
    public ResponseData buddhistChapterSrc(String id) {
        if (!SU.isNumber(id))
            return responseServiceHandler.bad("invalid param: " + id);
        int _id = Integer.parseInt(id);
        String text = bookMapper.getBuddhistChapterSrcById(_id);
        return responseServiceHandler.ok(text);
    }
}