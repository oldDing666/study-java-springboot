package com.afuya.controller;

import com.afuya.mapper.CategoryMapper;
import com.afuya.pojo.Category;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * @author: afuya
 * @program: StudyJavaV1
 * @date: 2021/9/18 4:41 下午
 */
@Controller
public class CategoryController {
    @Autowired
    CategoryMapper categoryMapper;

    @RequestMapping("/listCategory")
    public String listCategory(Model m, @RequestParam(value = "start", defaultValue = "0") int start, @RequestParam(value = "size", defaultValue = "5") int size) {
        PageHelper.startPage(start, size, "id desc");
        List<Category> cs = categoryMapper.findAll();
        PageInfo<Category> page = new PageInfo<>(cs);
        m.addAttribute("page", page);
        return "listCategory";
    }

    @RequestMapping(value = "/addCategory", method = RequestMethod.POST)
    public String addCategory(Category c, HttpServletRequest request, @RequestParam("file") MultipartFile file, Model m) {
        try {
            String fileName = "categoryImage_" + c.getId() + "_" + file.getOriginalFilename();
            String destFileName = request.getServletContext().getRealPath("") + "images" + File.separator + fileName;
            File destFile = new File(destFileName);
            destFile.getParentFile().mkdirs();
            file.transferTo(destFile);
            System.out.println(fileName);
//            m.addAttribute("fileName", fileName);
            c.setImgPath(fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
        categoryMapper.add(c);
        return "redirect:listCategory";
    }

    @RequestMapping("/deleteCategory")
    public String deleteCategory(Category c) {
        categoryMapper.delete(c.getId());
        return "redirect:listCategory";
    }

    @RequestMapping("/editCategory")
    public String editCategory(Category category, Model m) {
        Category c = categoryMapper.findOne(category.getId());
        m.addAttribute("c", c);
        return "editCategory";
    }

    @RequestMapping("/updateCategory")
    public String updateCategory(Category c, HttpServletRequest request, @RequestParam(value = "file") MultipartFile file) {
        try {
            String fileName = file.getOriginalFilename();
            String[] temp = fileName.split("\\.");
            fileName = c.getId() + "." + temp[temp.length - 1];
            String destFileName = request.getServletContext().getRealPath("") + "images" + File.separator + fileName;
            File destFile = new File(destFileName);
            destFile.getParentFile().mkdirs();
            file.transferTo(destFile);
            System.out.println(fileName);
            c.setImgPath(fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
        categoryMapper.update(c);
        return "redirect:listCategory";
    }
}
