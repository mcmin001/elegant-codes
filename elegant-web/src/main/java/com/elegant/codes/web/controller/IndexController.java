package com.elegant.codes.web.controller;

import com.elegant.codes.model.user.User;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {
    private static final Logger logger = LoggerFactory.getLogger(IndexController.class);

    public IndexController(){
        System.out.println("====================");
    }

    @ApiOperation("hello接口")
    @PostMapping(value = "/hello")
    public String index(@RequestParam(name = "id", required = false) String id){
        return "sucess";
    }

    @ApiOperation("测试获取用户信息接口")
    @PostMapping(value = "/user")
    public User user(@RequestParam(name = "id", required = false) String id){
        User user = new User();
        user.setUserName("tom");
        return user;
    }

    @ApiOperation("测试获取用户信息接口GET")
    @GetMapping(value = "/get/user")
    public User getUser(@RequestParam(name = "id", required = false) String id){
        logger.info("/get/user called. id={}", id);
        User user = new User();
        user.setUserName("tom");
        return user;
    }

}
