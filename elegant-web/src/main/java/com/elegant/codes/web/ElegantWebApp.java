package com.elegant.codes.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.elegant")
public class ElegantWebApp {
    public static void main(String[] args) {
        SpringApplication.run(ElegantWebApp.class, args);
    }
}
