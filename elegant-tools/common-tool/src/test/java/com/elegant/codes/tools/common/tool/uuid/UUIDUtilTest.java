package com.elegant.codes.tools.common.tool.uuid;


import org.junit.Test;

import java.util.Random;

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

    @Test
    public void timestampTest(){
        long timestamp = System.currentTimeMillis();
        String binary = Long.toBinaryString(timestamp);
        System.out.println("the timestamp of this moment is " + timestamp +
                "\nand binary=" + binary + "\nand the length of binary=" + binary.length());
    }

    @Test
    public void longToBinaryTest(){
        long var = 40;
        String varBinary = Long.toBinaryString(var);
        System.out.println("The binary of " + var + " is " + varBinary +
                "\nand the length of binary is " + varBinary.length());
    }

    @Test
    public void javaRandomTest(){
        double var = Math.random();
        System.out.println("Math.random=" + var);

        Random random = new Random();
        System.out.println("Random=" + random.nextInt());

        long timestampRandom = System.currentTimeMillis();
    }

    @Test
    public void printZero(){
        int num = 12;
        for(int i=0;i<num;i++){
            System.out.print(0);
        }
    }
}