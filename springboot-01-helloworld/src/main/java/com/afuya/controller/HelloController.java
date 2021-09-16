package com.afuya.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: afuya
 * @program: StudyJavaV1
 * @date: 2021/9/15 9:18 下午
 */

@RestController
public class HelloController {

    @RequestMapping("/hello")
    public String hello() {
        return "Hello SpringBoot! 2021.09.15";
    }

    @RequestMapping("/hi")
    public String hi() {
        return "Hi SpringBoot~";
    }
}
