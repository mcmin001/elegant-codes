package com.elegant.codes.service.user.impl;

import com.elegant.codes.dao.user.UserDao;
import com.elegant.codes.model.user.User;
import com.elegant.codes.service.user.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service("userService")
public class UserServiceImpl implements UserService {
    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserDao userDao;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void save(User user) {
        userDao.save(user);
    }

    @Override
    public User findById(String userId) {
        return userDao.findById(userId).orElse(new User());
    }
}
