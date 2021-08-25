package com.elegant.codes.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {
    private static final Logger logger = LoggerFactory.getLogger(IndexController.class);

    public IndexController(){
        System.out.println("====================");
    }

    @PostMapping(value = "/hello")
    public String index(@RequestParam(name = "id", required = false) String id){
        return "sucess";
    }
}
