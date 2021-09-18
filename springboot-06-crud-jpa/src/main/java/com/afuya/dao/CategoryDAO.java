package com.afuya.dao;

import com.afuya.pojo.Category;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author: afuya
 * @program: StudyJavaV1
 * @date: 2021/9/17 4:33 下午
 */
public interface CategoryDAO extends JpaRepository<Category, Integer> {

}
