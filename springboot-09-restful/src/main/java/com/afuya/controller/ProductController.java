package com.afuya.controller;

import com.afuya.mapper.ProductMapper;
import com.afuya.pojo.Product;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author: afuya
 * @program: StudyJavaV1
 * @date: 2021/9/20 10:24 上午
 */
@Controller
public class ProductController {

    @Autowired
    ProductMapper productMapper;

    @GetMapping("/products")
    public String listProduct(Model m, @RequestParam(value = "start", defaultValue = "0") int start, @RequestParam(value = "size", defaultValue = "5") int size) {
        PageHelper.startPage(start, size, "id desc");
        List<Product> ps = productMapper.findAll();
        PageInfo<Product> page = new PageInfo<>(ps);
        m.addAttribute("page", page);
        return "listProduct";
    }

    @PostMapping("/products")
    public String addProduct(Product p) {
        productMapper.add(p);
        return "redirect:/products";
    }

    @DeleteMapping("/products/{id}")
    public String deleteProduct(Product product) {
        productMapper.delete(product);
        // 斜杠不能省略，不然路径报错
        return "redirect:/products";
    }

    @GetMapping("/products/{id}")
    public String editProduct(Model m, Product product) {
        Product p = productMapper.edit(product);
        m.addAttribute("p", p);
        return "editProduct";
    }

    @PutMapping("/products/{id}")
    public String updateProduct(Product product) {
        productMapper.update(product);
        // 斜杠不能省略，不然路径报错
        return "redirect:/products";
    }
}
