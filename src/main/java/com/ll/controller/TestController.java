package com.ll.controller;


import com.ll.common.Result;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {


    @RequestMapping("/test")
    public Result testGet() {
        return new Result<>("Hello World");
    }
}
