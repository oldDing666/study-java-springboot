package com.afuya.mapper;

import com.afuya.pojo.Category;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author: afuya
 * @program: StudyJavaV1
 * @date: 2021/9/18 10:18 上午
 */
@Mapper
public interface CategoryMapper {

    @Select("select * from category_")
    public List<Category> findAll();


    @Insert("insert into category_ (name) values(#{name})")
    public int addCategory(Category category);

    @Delete("delete from category_ where id=#{id}")
    public void deleteCategory(int id);

    @Select("select * from category_ where id=#{id}")
    public Category findOne(int id);

    @Update("update category_ set name=#{name} where id=#{id}")
    public int updateCategory(Category category);
}
