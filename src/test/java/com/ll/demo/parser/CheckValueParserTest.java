package com.ll.demo.parser;

import com.ll.demo.annotation.parser.CheckValueParser;
import com.ll.demo.entity.User;
import org.junit.jupiter.api.Test;

public class CheckValueParserTest {


    @Test
    public void testParser() {
        User user = new User(1L, "kangkang", 18, "email");
        CheckValueParser.parse(user);
    }

}
