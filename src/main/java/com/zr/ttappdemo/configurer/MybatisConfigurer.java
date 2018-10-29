package com.zr.ttappdemo.configurer;

import com.baomidou.mybatisplus.extension.injector.LogicSqlInjector;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.extension.plugins.PerformanceInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * @author yuyi
 * @description mybatis 配置类
 * @date 16:43 2018/10/25
 */

@Configuration
public class MybatisConfigurer {

    /**
     * mybatis-plus SQL执行效率插件【生产环境可关闭】
     * @return
     */
    @Bean
    @Profile({"dev","test"})
    public PerformanceInterceptor performanceInterceptor() {
        return new PerformanceInterceptor();
    }

    /**
     * @author yuyi
     * @description mybatis-plus 分页插件
     * @date 17:05 2018/10/25
     * @return com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        PaginationInterceptor paginationInterceptor = new PaginationInterceptor();
        paginationInterceptor.setDialectType("mysql");
        return paginationInterceptor;
    }

    /**
     * @author yuyi
     * @description mybatis-plus 逻辑删除配置
     * @date 17:05 2018/10/25
     * @return com.baomidou.mybatisplus.extension.injector.LogicSqlInjector
     */
    @Bean
    public LogicSqlInjector logicSqlInjector() {
        return new LogicSqlInjector();
    }
}
