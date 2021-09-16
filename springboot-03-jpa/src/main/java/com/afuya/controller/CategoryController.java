package com.afuya.controller;

import com.afuya.dao.CategoryDAO;
import com.afuya.pojo.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author: afuya
 * @program: StudyJavaV1
 * @date: 2021/9/16 10:52 上午
 */

@Controller
public class CategoryController {
    @Autowired
    CategoryDAO categoryDAO;

    /**
     * @RequestMapping("/listCategory") 表示接收/listCategory映射
     * 通过model将数据传入到jsp页面中
     * return "listCategory"; 表示跳转到listCategory.jsp页面中
     * @param m
     * @return
     */
    @RequestMapping("/listCategory")
    public String listCategory(Model m) {
        List<Category> categories = categoryDAO.findAll();
        m.addAttribute("cs", categories);
        return "listCategory";
    }
}
