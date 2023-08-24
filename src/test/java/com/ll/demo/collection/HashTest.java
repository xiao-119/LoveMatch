package com.ll.demo.collection;

import org.junit.jupiter.api.Test;

import java.util.LinkedHashMap;
import java.util.Map;

public class HashTest {

    @Test
    public void testLinkedHash(){
        // LinkedHashMap
        Map<String, String> map = new LinkedHashMap<>();
        map.put("1", "1");
        map.put("2", "2");
        map.put("3", "3");
        map.put("4","4");
        map.put("5","5");
        map.put("6","6");
        map.put("7","7");
        map.put(null,null);

        map.forEach((s, s2) -> System.out.println(s + " " + s2));
    }
}
