package com.ll.demo.parser;

import com.ll.demo.annotation.parser.CheckValueParser;
import com.ll.demo.entity.User;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CheckValueParserTest {


    @Test
    public void testParser() {
        User user = new User(1L, "kangkang", 18, "email");
        CheckValueParser.parse(user);
    }


    @Test
    public void  testSubList(){
        List<String> list = Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8", "9", "10");
        ArrayList<String> strings = new ArrayList<>(list);
        List<String> subList = strings.subList(1, 5);

        strings.forEach(System.out::println);

        subList.forEach(System.out::println);

        String s = subList.get(0);
        System.out.println(s);
    }

}
