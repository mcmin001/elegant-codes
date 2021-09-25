package com.elegant.codes.service;


import com.alibaba.fastjson.JSON;
import com.elegant.codes.model.user.User;
import com.elegant.codes.service.user.UserService;
import com.elegant.codes.web.ElegantWebApp;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@SpringBootTest(classes = ElegantWebApp.class)
@RunWith(SpringRunner.class)
public class UserServiceImplTest {

    @Resource
    private UserService userService;

    @Before
    public void setUp() {
    }

    @Test
    @Rollback
    public void saveTest() {
        User user = new User();
        user.setUserId("100");
        userService.save(user);
        System.out.println(JSON.toJSONString(userService.findById("100")));
    }
}