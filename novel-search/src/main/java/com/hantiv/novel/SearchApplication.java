package com.hantiv.novel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * 搜索微服务启动器
 * @author Zhikun Han
 * @version 1.0
 * @since 2022/5/27
 */
@SpringBootApplication
@EnableFeignClients
@EnableScheduling
@ServletComponentScan
public class SearchApplication {

    public static void main(String[] args) {
        SpringApplication.run(SearchApplication.class);
    }
}
