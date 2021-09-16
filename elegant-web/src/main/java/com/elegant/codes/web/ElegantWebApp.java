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
        SpringApplication.run(ElegantWebApp.class, args);
    }
}
