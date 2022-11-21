package com.hantiv.novel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * 文件微服务启动器
 * @author Zhikun Han
 * @version 1.0
 * @since 2022/6/2
 */
@SpringBootApplication
@EnableFeignClients
@EnableScheduling
public class FileApplication {

    public static void main(String[] args) {
        SpringApplication.run(FileApplication.class);
    }
}
