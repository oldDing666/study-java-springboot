package com.afuya.controller;

import com.afuya.dao.CategoryDAO;
import com.afuya.pojo.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author: afuya
 * @program: StudyJavaV1
 * @date: 2021/9/17 4:34 下午
 */
@Controller
public class CategoryController {
    @Autowired
    CategoryDAO categoryDAO;

    @RequestMapping("/listCategory")
    public String listCategory(Model m, @RequestParam(value = "start", defaultValue = "0") int start, @RequestParam(value = "size", defaultValue = "5") int size) {
//        start = start < 0 ? 0 : start;
        Sort sort = new Sort(Sort.Direction.DESC, "id");
        Pageable pageable = new PageRequest(start, size, sort);
        Page<Category> page = categoryDAO.findAll(pageable);
        // 获取所有的category
//        page.getContent()
        // 获取当前的页数
//        page.getNumber()
        // 获取总页数
//        page.getTotalPages()
        m.addAttribute("page", page);
        return "listCategory";
    }

    @RequestMapping("/addCategory")
    public String addCategory(Category category) {
        categoryDAO.save(category);
        // 这里如果不使用重定向的话，访问的地址仍然是：http://localhost:8080/addCategory
        //        return "listCategory";
        // 使用重定向后，访问
        return "redirect:listCategory";
    }

    @RequestMapping("/deleteCategory")
    public String deleteCategory(Category category) {
        categoryDAO.delete(category.getId());
        return "redirect:listCategory";
    }

    @RequestMapping("/editCategory")
    public String editCategory(int id, Model m) {
        Category c = categoryDAO.findOne(id);
        m.addAttribute("c", c);
        return "editCategory";
    }

    @RequestMapping("/updateCategory")
    public String updateCategory(Category category) {
        categoryDAO.save(category);
        return "redirect:listCategory";
    }
}
