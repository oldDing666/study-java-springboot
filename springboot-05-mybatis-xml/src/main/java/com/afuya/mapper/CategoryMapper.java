package com.afuya.mapper;

import com.afuya.pojo.Category;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author: afuya
 * @program: StudyJavaV1
 * @date: 2021/9/16 4:55 下午
 */
@Mapper
public interface CategoryMapper {
    List<Category> findAll();
}
