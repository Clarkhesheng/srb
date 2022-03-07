package com.atguigu.srb.base;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.atguigu.srb", "com.atguigu.common"})
public class BaseApplication {
    public static void main(String[] args){
        SpringApplication.run(BaseApplication.class,args);
    }
}
