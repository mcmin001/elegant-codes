package com.elegant.codes.common.exception;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

public class TestErrorCode {
    @Test
    public void testClientErrorCode(){
        System.out.println(JSON.toJSON(ClientErrorCode.Code.PARAMS_ERROR.as("参数错误哦！")));
    }
}
