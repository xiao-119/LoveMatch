package com.ll.demo.service;

import com.ll.demo.entity.User;

import java.util.List;

public interface UserService {
    User getUserById(Long id);

    List<User> getAllUsers();

    int addUser(User user);

    int updateUser(User user);

    int deleteUser(Long id);
}
