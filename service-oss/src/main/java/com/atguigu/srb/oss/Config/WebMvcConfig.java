package com.atguigu.srb.oss.Config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@Slf4j
public class WebMvcConfig extends WebMvcConfigurerAdapter {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        log.error("添加源文件路径");
        System.out.println("添加源文件路径");
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
        //windows本地文件目录
        registry.addResourceHandler("/project/Cert/**").addResourceLocations("file:D:/project/Cert/");
        //return registry;
    }
}