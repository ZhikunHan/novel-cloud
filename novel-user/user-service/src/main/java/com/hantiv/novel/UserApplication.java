package com.hantiv.novel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * 用户微服务启动器
 * @author Zhikun Han
 * @version 1.0
 * @since 2022/5/27
 */
@SpringBootApplication
@EnableFeignClients
public class UserApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserApplication.class);
    }
}
