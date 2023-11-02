package com.ll.demo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ll.demo.entity.User;

import java.util.List;

public interface UserService extends IService<User> {
    User getUserById(Long id);

    List<User> getAllUsers();

    int addUser(User user);

    int updateUser(User user);

    int deleteUser(Long id);

    List<User> getUsers();
}
