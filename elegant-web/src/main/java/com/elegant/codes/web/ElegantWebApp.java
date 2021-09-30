package com.elegant.codes.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = "com.elegant")
@EnableJpaRepositories("com.elegant.codes.dao")
@EntityScan("com.elegant.codes.model")
public class ElegantWebApp {
    public static void main(String[] args) {
        // 同时支持代理 HTTP/HTTPS 请求
        System.setProperty("proxyHost", "127.0.0.1");
        System.setProperty("proxyPort", "9876");
        SpringApplication.run(ElegantWebApp.class, args);
    }
}
