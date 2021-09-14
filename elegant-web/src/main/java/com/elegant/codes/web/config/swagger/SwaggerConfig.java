package com.elegant.codes.web.config.swagger;

import org.springframework.boot.SpringBootVersion;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

@Configuration
public class SwaggerConfig implements WebMvcConfigurer {

    private final SwaggerProperties swaggerProperties;

    public SwaggerConfig(SwaggerProperties swaggerProperties) {
        this.swaggerProperties = swaggerProperties;
    }

    //可以创建多个Docket对象，添加进@Bean中 并使用 .groupName("张*") 添加多个分组，前提是名称不要重复
    @Bean
    public Docket createRestApi() {

        return new Docket(
                DocumentationType.OAS_30)
                .pathMapping("/")
                .groupName("张*")
                // 定义是否开启swagger，false为关闭，可以通过变量控制
                .enable(swaggerProperties.getEnable())

                // 将api的元信息设置为包含在json ResourceListing响应中。
                .apiInfo(apiInfo())

                // 接口调试地址
                .host(swaggerProperties.getTryHost())

                // 选择哪些接口作为swagger的doc发布
                .select()
                //RequestHandlerSelectors 配置要扫描接口的方式
                //RequestHandlerSelectors.basePackage("") //指定要扫描的包
                //any() 扫描全部
                //none() 都不扫描
                //.withClassAnnotation(RestController.class) 扫描类上的注解，比如这个只会扫描类上有RestController注解的类
                //.withMethodAnnotation(GetMapping.class) 扫描方法上的注解
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build()

                // 支持的通讯协议集合
                .protocols(newHashSet("https", "http"));
    }

    /**
     * API 页面上半部分展示信息
     * 可以new ApiInfo对象，到ApiInfo里面去看源码
     */
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title(swaggerProperties.getApplicationName() + " Api Doc")
                .description(swaggerProperties.getApplicationDescription())
                .contact(new Contact("helloworld", "com.z.cn", "helloworld@world.com"))
                .version("Application Version: " + swaggerProperties.getApplicationVersion() + ", Spring Boot Version: " + SpringBootVersion.getVersion())
                .build();
    }

    @SafeVarargs
    private final <T> Set<T> newHashSet(T... ts) {
        if (ts.length > 0) {
            return new LinkedHashSet<>(Arrays.asList(ts));
        }
        return null;
    }

}
