package com.afuya.mapper;

import com.afuya.pojo.Category;
import org.apache.ibatis.annotations.*;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author: afuya
 * @program: StudyJavaV1
 * @date: 2021/9/18 4:34 下午
 */
@Mapper
public interface CategoryMapper {

    @Select("select * from category_")
    public List<Category> findAll();

    @Insert("insert into category_ (name, imgPath) values(#{name}, #{imgPath})")
    public int add(Category c);

    @Delete("delete from category_ where id = #{id}")
    public void delete(int id);

    @Select("select * from category_ where id = #{id}")
    public Category findOne(int id);

    @Update("update category_ set name=#{name}, imgPath=#{imgPath} where id = #{id}")
    public int update(Category c);
}
