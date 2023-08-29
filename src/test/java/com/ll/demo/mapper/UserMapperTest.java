package com.ll.demo.mapper;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ll.demo.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;


@Slf4j
@SpringBootTest
public class UserMapperTest {
    @Autowired
    private UserMapper userMapper;

    private static String randString() {
        Random random = new Random();
        int length = random.nextInt(6) + 5;
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            int index = random.nextInt(characters.length());
            sb.append(characters.charAt(index));
        }
        String randomString = sb.toString();
        return randomString;
    }

    @Test
    public void insertBatch() {
        for (int i = 0; i < 10000; i++) {
            User user = new User();
            user.setName(randString());
            user.setAge(new Random().nextInt(100));
            user.setEmail(randString() + "@qq.com");
            userMapper.insert(user);
        }
    }

    @Test
    public void insertOne(){
        User user = new User();
        user.setName(randString());
        user.setAge(new Random().nextInt(100));
        user.setEmail(randString() + "@qq.com");
        userMapper.insert(user);
    }



    @Test
    public void testRandom(){
        Random random = new Random();
        System.out.println(random.nextInt(100));
        System.out.println(randString());
        System.out.println(randString());
        System.out.println(randString());
    }


    @Test
    public void filterDuplicate() {
        ArrayList<User> users = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            User user = new User();
            user.setName(randString());
            user.setAge(new Random().nextInt(100));
            user.setEmail(randString() + "@qq.com");
            users.add(user);
        }
        Date start = new Date();

        List<User> us = filterDuplicateBatch(users);
        log.info("{}", us.size());

        Date now = new Date();
        long esTime = now.getTime() - start.getTime();
        log.info("{}", esTime);
    }

    private List<User> filterDuplicateBatch(List<User> users) {
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper();
        for (User user : users) {
            queryWrapper.eq(User::getName, user.getName())
                    .eq(User::getAge, user.getAge())
                    .or();
        }
        List<User> us = userMapper.selectList(queryWrapper);
        return us;
    }


    private List<User> filterDuplicateOneByOne(List<User> users) {
        ArrayList<User> result = new ArrayList<>();
        for (User user : users) {
            LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper();
            queryWrapper.eq(User::getName, user.getName())
                    .eq(User::getAge, user.getAge());
            User u = userMapper.selectOne(queryWrapper);
            if (u != null) {
                result.add(user);
            }
        }
        return result;
    }

    @Test
    public void selectAll() {
        PageHelper.startPage(1, 2);
        List<User> users = userMapper.selectList(null);
        PageInfo<User> pageInfo = new PageInfo<>(users);
        pageInfo.getList().forEach(System.out::println);
    }


    @Test
    public void selectAll2() {
        List<User> users = userMapper.selectList(null);
        users.forEach(System.out::println);
    }

    @Test
    public void selectOne(){

        User user = userMapper.selectById(1696495526011191297L);
        System.out.println(user);
    }

}
