package com.afuya.controller;

import com.afuya.mapper.UserMapper;
import com.afuya.pojo.User;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author: afuya
 * @program: StudyJavaV1
 * @date: 2021/9/20 2:54 下午
 */
@Controller
public class UserController {
    @Autowired
    UserMapper userMapper;

    @GetMapping("users")
    public String listUser(Model m, @RequestParam(value = "start", defaultValue = "0") int start, @RequestParam(value = "size", defaultValue = "5") int size) {
        PageHelper.startPage(start, size, "id desc");
        List<User> us = userMapper.findAll();
        PageInfo<User> page = new PageInfo<>(us);
        m.addAttribute("page", page);
        return "listUser";
    }

    @PostMapping("users")
    public String addUser(User user) {
        userMapper.add(user);
        return "redirect:/users";
    }

    @DeleteMapping("users/{id}")
    public String deleteUser(User user) {
        userMapper.delete(user);
        return "redirect:/users";
    }

    @GetMapping("users/{id}")
    public String editUser(User user, Model m) {
        User u = userMapper.findOne(user);
        m.addAttribute("u", u);
        return "editUser";
    }

    @PutMapping("users/{id}")
    public String updateUser(User user) {
        userMapper.update(user);
        return "redirect:/users";
    }
}
