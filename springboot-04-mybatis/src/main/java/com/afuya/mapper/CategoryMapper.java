package com.afuya.mapper;

import com.afuya.pojo.Category;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author: afuya
 * @program: StudyJavaV1
 * @date: 2021/9/16 11:29 上午
 */

/**
 * @Mapper 表示这时一个mybatis mapper接口
 * @Select("select * from category_") 表示调用该方法会执行对应的sql语句
 */
@Mapper
public interface CategoryMapper {

    @Select("select * from category_")
    List<Category> findAll();
}
