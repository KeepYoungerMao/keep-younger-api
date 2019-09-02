package com.mao.mapper.data;

import com.mao.entity.book.Book;
import com.mao.entity.book.Chapter;
import com.mao.entity.book.SimpleBook;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 书籍数据处理
 * @author mao by 11:44 2019/9/2
 */
@Repository
@Mapper
public interface BookMapper {

    //根据朝代和分类查询书籍列表
    List<SimpleBook> getBookList(@Param("dynasty") int dynasty,
                                 @Param("type") int type, @Param("page") int page);

    //根据id查询书籍详细信息
    Book getBookById(@Param("id") int id);

    //根据书籍id查询书籍章节列表
    List<Chapter> getChapterByBookId(@Param("id") int id);

    //根据id查询章节详情
    String getChapterSrcById(@Param("id") int id);
}