package com.ll.demo.controller;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ll.demo.common.R;
import com.ll.demo.dto.PageDto;
import com.ll.demo.entity.User;
import com.ll.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

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

    @GetMapping("/allUser")
    public R<?> all(Integer pageNo, Integer pageSize) {
        PageHelper.startPage(pageNo, pageSize);
        List<User> allUsers = userService.getAllUsers();
        PageInfo<User> pageInfo = new PageInfo<>(allUsers);
        return R.success(pageInfo);
    }

    @GetMapping("/allUser22")
    public R<?> allObjetc(PageDto page) {

        PageHelper.startPage(page.getPageNo(), page.getPageSize());
        List<User> allUsers = userService.getAllUsers();
        PageInfo<User> pageInfo = new PageInfo<>(allUsers);
        return R.success(pageInfo);
    }

    /**
     * json请求转为对象, 必须加 @RequestBody
     * Content-Type:application/json
     *
     * {
     *     "pageNo": "1",
     *     "pageSize": 2
     * }
     * @param page
     * @return
     */
    @PostMapping("/postUsers") //
    public R<?> postUsers(@Valid @RequestBody PageDto page) {

        PageHelper.startPage(page.getPageNo(), page.getPageSize());
        List<User> allUsers = userService.getAllUsers();
        PageInfo<User> pageInfo = new PageInfo<>(allUsers);
        return R.success(pageInfo);
    }
}
