package com.afuya.controller;

import com.afuya.mapper.CategoryMapper;
import com.afuya.pojo.Category;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author: afuya
 * @program: StudyJavaV1
 * @date: 2021/9/18 10:28 上午
 */
@Controller
public class CategoryController {
    @Autowired
    CategoryMapper categoryMapper;

    @RequestMapping("/listCategory")
    public String listCategor(Model m, @RequestParam(value = "start", defaultValue = "0") int start, @RequestParam(value = "size", defaultValue = "5") int size) {
        PageHelper.startPage(start, size, "id desc");
        List<Category> cs = categoryMapper.findAll();
        PageInfo<Category> page = new PageInfo<>(cs);
        m.addAttribute("page", page);
        return "listCategory";
    }

    @RequestMapping("/addCategory")
    public String addCategory(Category category) {
        categoryMapper.addCategory(category);
        return "redirect:listCategory";
    }

    @RequestMapping("/deleteCategory")
    public String deleteCategory(Category category) {
        categoryMapper.deleteCategory(category.getId());
        return "redirect:listCategory";
    }

    @RequestMapping("/editCategory")
    public String editCategory(Category category, Model m) {
        Category c = categoryMapper.findOne(category.getId());
        m.addAttribute("c", c);
        return "editCategory";
    }

    @RequestMapping("/updateCategory")
    public String updateCategory(Category category) {
        categoryMapper.updateCategory(category);
        return "redirect:listCategory";
    }
}
