package com.xiaobin.example.springboot.config;

import com.github.pagehelper.PageHelper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;

/**
 * Created with IntelliJ IDEA.
 * User: xiaobin3
 *
 * Email: xiaobin3@asiainfo.com
 * Date: 2018/5/7
 * Time: 22:33
 * To change this template use File | Settings | File Templates.
 * 注解@Configuration 表示PageHelperConfig 这个类是用来做配置的。
 * 注解@Bean 表示启动PageHelper这个拦截器。
 * offsetAsPageNum:设置为true时，会将RowBounds第一个参数offset当成pageNum页码使用.
 */
@Configuration
public class PageHelperConfig {
    @Bean
    public PageHelper pageHelper(){
        PageHelper pageHelper = new PageHelper();
        Properties properties = new Properties();
//        offsetAsPageNum:设置为true时，会将RowBounds第一个参数offset当成pageNum页码使用.
        properties.setProperty("offsetAsPageNum", "true");
//        rowBoundsWithCount:设置为true时，使用RowBounds分页会进行count查询.
        properties.setProperty("rowBoundsWithCount", "true");
//        reasonable：启用合理化时，如果pageNum<1会查询第一页，如果pageNum>pages会查询最后一页。
        properties.setProperty("reasonable", "true");
        pageHelper.setProperties(properties);
        return pageHelper;
    }
}
