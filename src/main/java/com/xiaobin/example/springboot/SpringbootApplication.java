package com.xiaobin.example.springboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.devtools.autoconfigure.DevToolsDataSourceAutoConfiguration;
import org.springframework.boot.web.servlet.ServletComponentScan;

//这里需要注意的，此时如果直接启动项目，
// 在浏览器中输入http://127.0.0.1:8080/druid/index.html会报404，
// 需要在启动类上加上@ServletComponentScan注解，
// 才能够在启动的时候扫描到自己编写的servlet和filter。

@SpringBootApplication
@MapperScan(basePackages = "com.xiaobin.example.springboot.mapper")
//@ServletComponentScan
public class SpringbootApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootApplication.class, args);
    }
}
