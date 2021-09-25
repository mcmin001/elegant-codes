package com.elegant.codes.service.user.impl;


import com.elegant.codes.model.user.User;
import com.elegant.codes.service.user.UserService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import javax.annotation.Resource;

@SpringBootTest
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
    }
}