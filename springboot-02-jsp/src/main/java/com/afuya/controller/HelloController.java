package com.afuya.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.DateFormat;
import java.util.Date;

/**
 * @author: afuya
 * @program: StudyJavaV1
 * @date: 2021/9/15 10:09 下午
 */
@Controller
public class HelloController {

    /**
     * 这时返回的"hello"就不是字符串，而是根据配置文件的设置，去寻找hello.jsp文件
     * @param m
     * @return
     */
    @RequestMapping("/hello")
    public String hello(Model m) {
        m.addAttribute("now", DateFormat.getDateTimeInstance().format(new Date()));
        return "hello";
    }

    @RequestMapping("/hi")
    public String func(Model m){
        m.addAttribute("now", DateFormat.getDateTimeInstance().format(new Date()));
        return "hi";
    }
}
