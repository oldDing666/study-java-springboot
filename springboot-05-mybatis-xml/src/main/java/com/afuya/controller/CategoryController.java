package com.afuya.controller;

import com.afuya.mapper.CategoryMapper;
import com.afuya.pojo.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author: afuya
 * @program: StudyJavaV1
 * @date: 2021/9/16 4:58 下午
 */
@Controller
public class CategoryController {
    @Autowired
    CategoryMapper categoryMapper;

    @RequestMapping("/listCategory")
    public String listCategory(Model m) {
        List<Category> cs = categoryMapper.findAll();
        m.addAttribute("cs", cs);
        return "listCategory";
    }
}
