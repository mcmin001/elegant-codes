package com.elegant.codes.service.user.impl;

import com.elegant.codes.service.user.TestService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service("testService")
public class TestServiceImpl implements TestService {
    private static final Logger logger = LoggerFactory.getLogger(TestServiceImpl.class);

    @Override
    public String testException() {
        String result = "";
        try{
            int a = 0;
            int b = 1;
            int c = b/a;
            return String.valueOf(c);
        }catch (Exception e){
            logger.error(e.getMessage(), e);
            throw e;
        }
    }
}
