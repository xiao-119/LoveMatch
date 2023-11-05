package com.ll.demo.controller;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ll.demo.common.R;
import com.ll.demo.config.MySessionScopedBean;
import com.ll.demo.entity.User;
import com.ll.demo.service.UserService;
import io.swagger.v3.oas.annotations.Hidden;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;

//@Tag(name = "user", description = "Tutorial management APIs")
@RestController
@RequestMapping("/user")
//@Hidden
public class UserController {


    @Autowired
    UserService userService;

    @Autowired
    private MySessionScopedBean sessionBean;

//    @Autowired
//    public UserController(MySessionScopedBean sessionScopedBean) {
//        this.sessionBean = sessionScopedBean;
//    }

    @Operation(summary = "查看指定id用户", description = "", tags = {"aaa接口看这里"})
    @GetMapping("/{id}")
    public R<?> user(@PathVariable Long id) {
        User user = userService.getUserById(id);
        return R.success(user);
    }

    @Operation(summary = "查看指定wxId用户", description = "", tags = {"aaa接口看这里"})
    @GetMapping("/wxId/{wxId}")
    public R<?> userByWxId(@PathVariable String wxId) {


        User user = userService.getOne(Wrappers.<User>lambdaQuery().eq(User::getWxId, wxId));
        return R.success(user);
    }

    @Operation(summary = "查看所有注册用户", description = "", tags = {"aaa接口看这里"})
    @GetMapping("/allUser")
    public R<?> all(Integer pageNo, Integer pageSize) {
        PageHelper.startPage(pageNo, pageSize);
        List<User> allUsers = userService.getAllUsers();
        PageInfo<User> pageInfo = new PageInfo<>(allUsers);
        return R.success(pageInfo);
    }

    @Operation(summary = "wxId注册修改user", description = "", tags = {"aaa接口看这里"})
    @PostMapping("/edit")
    public R<?> registerEdit(@Valid @RequestBody User user) {
        user.setId(null);
        boolean i = userService.saveOrUpdate(user, Wrappers.<User>lambdaUpdate().eq(User::getWxId, user.getWxId()));
        return R.success(i);
    }


    @GetMapping("/login")
    @Hidden
    public String login(String wxId, HttpSession session) {
        // 假设这里是你的登录逻辑，验证了wxId之后
        session.setAttribute("wxId", wxId); // 将用户信息存入session
        sessionBean.setUser(User.builder().wxId(wxId).build());
        return "success";
    }

    @Operation(summary = "获取当前登录用户wxId,openId", description = "", tags = {"aaa接口看这里"})
    @GetMapping("/current-user")
    @Hidden
    public R<?> currentUser() {

        return R.success(sessionBean.getUser());
    }
}
