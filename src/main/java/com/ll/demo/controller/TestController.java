package com.ll.demo.controller;


import com.ll.demo.common.R;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {

    @RequestMapping("/test")
    public R<?> testGet() {
        return R.success("Hello World");
    }
}
