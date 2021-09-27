package com.elegant.codes.tools.common.tool.uuid;


import org.junit.Test;

public class UUIDUtilTest{
    @Test
    public void uuidTest(){
        for(int i=0;i<20;i++){
            System.out.println(UUIDUtil.getUUID());
        }
    }
}