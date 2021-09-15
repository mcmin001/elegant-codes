package com.elegant.codes.web.core;

import com.elegant.codes.web.common.JsonResult;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;
import springfox.documentation.spring.web.json.Json;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.SwaggerResource;
import springfox.documentation.swagger.web.UiConfiguration;

import java.util.ArrayList;

@RestControllerAdvice(basePackages = "com.elegant.codes.web.controller")
public class JsonResultResponseAdvice implements ResponseBodyAdvice<Object>{

    @Override
    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> aClass) {
        return !returnType.getDeclaringClass().equals(Docket.class);
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType,
                                  MediaType mediaType, Class<? extends HttpMessageConverter<?>> aClass,
                                  ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
        if (body instanceof JsonResult
                || body instanceof Json
                || body instanceof UiConfiguration
                || (body instanceof ArrayList && ((ArrayList) body).get(0) instanceof SwaggerResource)){
            return body;
        }
        return new JsonResult<Object>(body);
    }
}
