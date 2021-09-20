package com.afuya.mapper;

import com.afuya.pojo.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author: afuya
 * @program: StudyJavaV1
 * @date: 2021/9/20 2:48 下午
 */

@Mapper
public interface UserMapper {

    @Select("select * from user")
    public List<User> findAll();

    @Select("select * from user where id = #{id}")
    public User findOne(User user);

    @Insert("insert into user (name,password) values(#{name}, #{password})")
    public int add(User user);

    @Delete("delete from user where id = #{id}")
    public void delete(User user);

    // 返回值类型要是int，不能是User，不然会报错500
    @Update("update user set name = #{name}, password=#{password} where id = #{id}")
    public int update(User user);
}
