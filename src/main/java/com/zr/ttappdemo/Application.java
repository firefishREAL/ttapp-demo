package com.zr.ttappdemo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author yuyi
 * @description 启动器
 * @date 17:48 2018/10/25
 */
@SpringBootApplication
@MapperScan("com.zr.ttappdemo.dao")
@EnableSwagger2
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
