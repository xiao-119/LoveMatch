package com.ll.demo.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@SpringBootTest
public class PathTest {



    @Test
    public void testPath(){
        String path = System.getProperty("user.dir");
        Path resolve = Paths.get(path).resolve("pom.xml");
        boolean exists = Files.exists(resolve);
        System.out.println(exists);
    }
}
