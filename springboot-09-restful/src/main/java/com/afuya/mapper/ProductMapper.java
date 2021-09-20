package com.afuya.mapper;

import com.afuya.pojo.Product;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author: afuya
 * @program: StudyJavaV1
 * @date: 2021/9/20 10:11 上午
 */
@Mapper
public interface ProductMapper {

    @Select("select * from product")
    public List<Product> findAll();

    @Insert("insert into product (name,price)values(#{name},#{price})")
    public int add(Product p);

    @Delete("delete from product where id = #{id}")
    public void delete(Product p);

    @Select("select * from product where id = #{id}")
    public Product edit(Product p);

    // 返回值类型要是int，不能是User，不然会报错500
    @Update("update product set name = #{name}, price = #{price} where id = #{id}")
    public int update(Product p);
}
