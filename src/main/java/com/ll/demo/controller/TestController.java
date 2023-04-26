package com.ll.demo.controller;


import com.ll.demo.common.R;
import com.ll.demo.entity.User;
import com.ll.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    UserService userService;

    @RequestMapping("/test")
    public R<?> testGet() {
        return R.success("Hello World");
    }


    @GetMapping("/user")
    public R<?> user() {
        User user = userService.getUserById(1L);
        return R.success(user);
    }
}
