package com.hantiv.novel.monitor;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 监控服务启动器
 * @author Zhikun Han
 * @version 1.0
 * @since 2022/5/27
 */
@EnableAdminServer
@SpringBootApplication
public class NovelMonitorApplication {

    public static void main(String[] args) {
        SpringApplication.run(NovelMonitorApplication.class, args);
    }

}
