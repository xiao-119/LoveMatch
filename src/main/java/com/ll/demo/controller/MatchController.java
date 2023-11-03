package com.ll.demo.controller;


import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.ll.demo.common.R;
import com.ll.demo.entity.Match;
import com.ll.demo.entity.User;
import com.ll.demo.service.UserService;
import com.ll.demo.service.impl.MatchServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/match")
public class MatchController {

    @Autowired
    UserService userService;

    @Autowired
    MatchServiceImpl matchService;

    @Operation(summary = "获取所有未配对用户", description = "", tags = {"aaa接口看这里"})
    @GetMapping("/allUnMatch")
    public R<List<User>> allUnMatch() {
        List<User> users = userService.list(Wrappers.<User>lambdaQuery().eq(User::getIsDel, 0));
        List<Match> matches = matchService.list(Wrappers.<Match>lambdaQuery().eq(Match::getIsDel, 0));

        for (Match match : matches) {
            users.removeIf(user -> user.getWxId().equals(match.getWxId1()) || user.getWxId().equals(match.getWxId2()));
        }
        return R.success(users);
    }

    @Operation(summary = "获取所有已经配对用户", description = "", tags = {"aaa接口看这里"})
    @GetMapping("/allMatched")
    public R<?> allMatched() {
        List<User> users = userService.list(Wrappers.<User>lambdaQuery().eq(User::getIsDel, 0));
        List<Match> matches = matchService.list(Wrappers.<Match>lambdaQuery().eq(Match::getIsDel, 0));
        ArrayList<ArrayList<User>> matchedUsers = new ArrayList<>();
        for (Match match : matches) {
            ArrayList<User> userArrayList = new ArrayList<>();
            User user1 = users.stream().filter(user -> user.getWxId().equals(match.getWxId1())).findFirst().orElse(null);
            User user2 = users.stream().filter(user -> user.getWxId().equals(match.getWxId2())).findFirst().orElse(null);
            userArrayList.add(user1);
            userArrayList.add(user2);
            matchedUsers.add(userArrayList);
        }
        return R.success(matchedUsers);
    }


    @Operation(summary = "查询某个wxId配对用户信息", description = "", tags = {"aaa接口看这里"})
    @GetMapping("/findOne/{wxId}")
    public R<?> findOne(@PathVariable String wxId) {
        Match one = matchService.getOne(Wrappers.<Match>lambdaQuery().eq(Match::getIsDel, 0)
                .and(c -> c.eq(Match::getWxId1, wxId).or().eq(Match::getWxId2, wxId)));
        return R.success(one);
    }


    @Operation(summary = "所有未配对用户男女随机匹配,返回剩下的人", description = "", tags = {"aaa接口看这里"})
    @GetMapping("/randomMatch")
    public R<?> randomMatch() {
        List<User> users = allUnMatch().getData();

        Collections.shuffle(users);

        Map<String, List<User>> collect = users.stream().collect(Collectors.groupingBy(User::getSex));

        List<User> males = collect.get("male");
        List<User> females = collect.get("female");
        List<User> min = males.size() < females.size() ? males : females;
        List<User> max = males.size() > females.size() ? males : females;

        for (int i = 0; i < min.size(); i++) {
            matchService.save(Match.builder().wxId1(min.get(i).getWxId()).wxId2(max.get(i).getWxId()).build());
        }

        // 还有如下没有配对
        List<User> left = max.subList(min.size(), max.size());
        return R.success(left);
    }


    @Operation(summary = "清除所有配对关系", description = "", tags = {"aaa接口看这里"})
    @GetMapping("/clear")
    public R<?> clear() {
        boolean update = matchService.update(Wrappers.<Match>lambdaUpdate().set(Match::getIsDel, 1));
        return R.success(update);
    }

    @Operation(summary = "给指定两人wxId添加配对", description = "", tags = {"aaa接口看这里"})
    @GetMapping("/add/{wxId1}/{wxId2}")
    public R<?> userByWxId(@PathVariable String wxId1, @PathVariable String wxId2) {
        Match build = Match.builder().wxId1(wxId1).wxId2(wxId2).build();

        boolean save = matchService.save(build);
        return R.success(save);
    }


    @Operation(summary = "删除某个wxId的配对", description = "", tags = {"aaa接口看这里"})
    @GetMapping("/del/{wxId}")
    public R<?> userByWxId(@PathVariable String wxId) {

        boolean update = matchService.update(Wrappers.<Match>lambdaUpdate().set(Match::getIsDel, 1)
                .and(i -> i.eq(Match::getWxId1, wxId).or().eq(Match::getWxId2, wxId)));
        return R.success(update);
    }
}
