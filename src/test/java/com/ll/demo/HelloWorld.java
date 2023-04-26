package com.ll.demo;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.UnsupportedEncodingException;

public class HelloWorld {

    private static final Logger LOGGER = LoggerFactory.getLogger(HelloWorld.class);
    public static void main(String[] args) {
        System.out.println("hello");
    }


    @Test
    public void testString() throws UnsupportedEncodingException {
        byte[] bytes = "你好".getBytes("GBK");
        String gbk = new String(bytes, "iso-8859-1");
        LOGGER.info("hello world");
    }
}
