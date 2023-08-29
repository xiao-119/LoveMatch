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


    @Test
    public void testSplit(){
        String sql = "select * from user where id = 1 limit 1, 10";

        String[] limits = sql.split("limit1");
        if (limits.length > 1) {
            String[] split = limits[1].split(",");
            String offset = split[0];
            String limit = split[1];
            System.out.println(offset);
            System.out.println(limit);
        }


    }
}
