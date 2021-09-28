package com.elegant.codes.tools.common.tool.uuid;


import org.junit.Test;

public class UUIDUtilTest{
    @Test
    public void uuidTest(){
        for(int i=0;i<20;i++){
            System.out.println(Long.toBinaryString(Long.valueOf(UUIDUtil.getUUID())) + " - " + Long.toBinaryString(Long.valueOf(UUIDUtil.getUUID())).length());
        }
        String v = "110001100011000011100100100010011101111111010100000000000000";
        System.out.println("fuck=" + v.length());
    }
}