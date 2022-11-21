package com.hantiv.novel;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

/**
 * 作家微服务启动器
 * @author Zhikun Han
 * @version 1.0
 * @since 2022/5/27
 */
@SpringBootApplication
//@ComponentScan(excludeFilters = {@ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, classes = {CacheService.class})})
@MapperScan("com.hantiv.novel.author.mapper")
@EnableFeignClients
public class AuthorApplication {

    public static void main(String[] args) {
        SpringApplication.run(AuthorApplication.class);
    }
}
