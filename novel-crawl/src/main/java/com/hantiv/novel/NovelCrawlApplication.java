package com.hantiv.novel;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.net.InetAddress;

@SpringBootApplication
@EnableCaching
@EnableScheduling
@ServletComponentScan
@MapperScan(basePackages = {"com.hantiv.novel.mapper"})
@Slf4j
public class NovelCrawlApplication {

    public static void main(String[] args) {
        SpringApplication.run(NovelCrawlApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext ctx){
        return args -> {
            log.info("项目启动啦，访问路径：{}", "http://" + InetAddress.getLocalHost().getHostAddress() +":" +ctx.getEnvironment().getProperty("server.port"));
        };
    }

}
