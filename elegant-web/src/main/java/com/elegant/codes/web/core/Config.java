package com.elegant.codes.web.core;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class Config implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //加载登录适配器
        registry.addInterceptor(new LogTraceInterceptor())
                .addPathPatterns("/**");
    }
}
