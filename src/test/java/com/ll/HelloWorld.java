package com.ll;

import org.junit.jupiter.api.Test;

import java.io.UnsupportedEncodingException;

public class HelloWorld {
    public static void main(String[] args) {
        System.out.println("hello");
    }


    @Test
    public void testString() throws UnsupportedEncodingException {
        byte[] bytes = "你好".getBytes("GBK");
        String gbk = new String(bytes, "iso-8859-1");
        System.out.println(gbk);
    }
}
