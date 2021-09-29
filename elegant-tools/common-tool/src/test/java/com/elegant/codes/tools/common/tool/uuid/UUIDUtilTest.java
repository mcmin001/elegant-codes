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

    @Test
    public void testBinary(){
        long var1 = 5;
        int var2 = 1;
        long var3 = var1 << 1 | var2;
        System.out.println("var3=" + var3);
        System.out.println("var3 in binary=" + Long.toBinaryString(var3));
    }
}