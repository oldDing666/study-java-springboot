package com.afuya.dao;

import com.afuya.pojo.Category;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author: afuya
 * @program: StudyJavaV1
 * @date: 2021/9/16 10:47 上午
 */

/**
 * CategoryDAO接口继承了JpaRepository接口
 * 这个接口就提供了crud、分页等功能
 */
public interface CategoryDAO extends JpaRepository<Category, Integer> {

}
