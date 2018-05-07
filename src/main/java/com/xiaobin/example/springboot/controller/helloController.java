package com.xiaobin.example.springboot.controller;

import com.xiaobin.example.springboot.domain.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: xiaobin3
 *
 * @author : xiaob
 * Email: xiaobin3@asiainfo.com
 * Date: 2018/5/7
 * Time: 19:49
 * To change this template use File | Settings | File Templates.
 */
//添加 @RestController，默认类中的方法都会以json的格式返回
@RestController
@RequestMapping("/hello")
public class helloController {

    @RequestMapping("/springboot")
    public String hello() {
        System.out.println("Hello SpringBoot!");
        return "Hello SpringBoot!Hello SpringBoot!";
    }

    @RequestMapping("/user")
    public User getUser(){
        User user = new User();
        user.setNickName("maomao");
        user.setUsername("bin");
        user.setPassword("*&UJH^%++====");
        return user;
    }
}
