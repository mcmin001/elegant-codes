package com.elegant.codes.web.core;

import org.apache.commons.lang3.RandomStringUtils;

public class TraceLogUtils {
    public static String getTraceId(){
        return RandomStringUtils.randomAlphanumeric(32);
    }

    public static void main(String[] args) {
        System.out.println(getTraceId());
    }
}
