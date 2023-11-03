package com.ll.demo.controller;

import cn.hutool.Hutool;
import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ll.demo.annotation.WebLog;
import com.ll.demo.common.R;
import com.ll.demo.dto.PageDto;
import com.ll.demo.dto.UserDto;
import com.ll.demo.entity.User;
import com.ll.demo.service.UserService;
import com.ll.demo.util.PageUtils;
import io.swagger.v3.oas.annotations.Hidden;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
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

    @Operation(summary = "注册修改user", description = "", tags = {"aaa接口看这里"})
    @PostMapping("/edit")
    public R<?> registerEdit(@Valid @RequestBody User user) {
        user.setId(null);
        boolean i = userService.saveOrUpdate(user, Wrappers.<User>lambdaUpdate().eq(User::getWxId, user.getWxId()));
        return R.success(i);
    }

    @Operation(summary = "根据wxId登录", description = "", tags = {"aaa接口看这里"})
    @GetMapping("/login")
    public String login(String wxId, HttpSession session) {
        // 假设这里是你的登录逻辑，验证了wxId之后
        session.setAttribute("wxId", wxId); // 将用户信息存入session
        return "success";
    }

    @Operation(summary = "获取当前登录用户", description = "", tags = {"aaa接口看这里"})
    @GetMapping("/current-user")
    public String currentUser(HttpSession session) {
        String wxId = (String) session.getAttribute("wxId");
        if (wxId != null) {
            return "current-user.wx_id: " + wxId;
        } else {
            return "not login";
        }
    }

    @GetMapping("/allUser22")
    @Hidden
    public R<?> allObjetc(PageDto page) {

        PageHelper.startPage(page.getPageNo(), page.getPageSize());
        List<User> allUsers = userService.getAllUsers();
        PageInfo<User> pageInfo = new PageInfo<>(allUsers);
        return R.success(pageInfo);
    }


//    @Operation(summary = "注册user", description = "", tags = {"aaa接口看这里"})
//    @PostMapping("/register")
    public R<?> register(@RequestBody User user) {


        User u = new User();
        BeanUtil.copyProperties(user, u,"id", "updateTime");
        boolean i = userService.save(user);
        return R.success(i);
    }




    /**
     * json请求转为对象, 必须加 @RequestBody
     * Content-Type:application/json
     * <p>
     * {
     * "pageNo": "1",
     * "pageSize": 2
     * }
     *
     * @param page
     * @return
     */
    @Operation(summary = "测试接口hello", description = "测试接口description", tags = {"测试接口tags", "测试接口tags2"})
    @ApiResponses({
//            @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = R.class), mediaType = "application/json") })
    })
    @PostMapping("/postUsers") //
    @WebLog
    @Hidden
    public R<PageInfo<UserDto>> postUsers(@Valid @RequestBody PageDto page) {

        PageHelper.startPage(page.getPageNo(), page.getPageSize());
        List<User> allUsers = userService.getAllUsers();
        PageInfo<User> pageInfo = new PageInfo<>(allUsers);

        PageInfo<UserDto> replace = PageUtils.replace(pageInfo, UserDto.class);

        return R.success(replace);
    }
}
