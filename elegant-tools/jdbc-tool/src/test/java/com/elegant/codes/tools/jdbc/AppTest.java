package com.elegant.codes.tools.jdbc;

import org.junit.Test;

public class AppTest {
    @Test
    public void testClass(){
        try {
            Class.forName("");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
