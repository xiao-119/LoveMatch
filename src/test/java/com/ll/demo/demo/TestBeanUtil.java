package com.ll.demo.demo;

import cn.hutool.core.bean.BeanUtil;
import com.ll.demo.dto.UserDto;
import com.ll.demo.entity.User;
import org.junit.jupiter.api.Test;

public class TestBeanUtil {



    @Test
    public void testHuCopy(){

        User user = new User();
        user.setId(1L);
        user.setName("ll");
//        user.setAge(18);
        user.setEmail("110@gamil");

        UserDto userDto = new UserDto();
        BeanUtil.copyProperties(user, userDto);
        System.out.println(userDto);

    }
}
