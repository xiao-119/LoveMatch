package com.ll.demo.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.ll.demo.entity.User;
import com.ll.demo.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@ExtendWith(SpringExtension.class)
@SpringBootTest
class UserServiceImplTest {

    @Autowired
    private UserMapper mockUserMapper;


    @SpyBean
    private UserServiceImpl userServiceImplUnderTest;


    @Test
    public void testUserMapper() {
//        User user = mockUserMapper.selectById(1);
//        System.out.println(user);
//        User user1 = new User(5L, "", 18, "");
//        when(userServiceImplUnderTest.getAllUsers()).thenReturn(List.of(user1));
//        List<User> allUsers = userServiceImplUnderTest.getAllUsers();
//        System.out.println(allUsers);
//
//        User userById = userServiceImplUnderTest.getUserById(1L);
//        System.out.println(userById);
    }



    @Test
    void testGetUserById() {
        // Setup
        final User expectedResult = new User();
        expectedResult.setId(0L);
        expectedResult.setName("name");
        expectedResult.setAge(0);
        expectedResult.setEmail("email");

        // Configure UserMapper.selectById(...).
        final User user = new User();
        user.setId(0L);
        user.setName("name");
        user.setAge(0);
        user.setEmail("email");
        when(mockUserMapper.selectById(0L)).thenReturn(user);

        // Run the test
        final User result = userServiceImplUnderTest.getUserById(0L);

        // Verify the results
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    void testGetAllUsers() {
        // Setup
        final User user = new User();
        user.setId(0L);
        user.setName("name");
        user.setAge(0);
        user.setEmail("email");
        final List<User> expectedResult = Arrays.asList(user);

        // Configure UserMapper.selectList(...).
        final User user1 = new User();
        user1.setId(0L);
        user1.setName("name");
        user1.setAge(0);
        user1.setEmail("email");
        final List<User> users = Arrays.asList(user1);
        when(mockUserMapper.selectList(any(Wrapper.class))).thenReturn(users);

        // Run the test
        final List<User> result = userServiceImplUnderTest.getAllUsers();

        // Verify the results
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    void testGetAllUsers_UserMapperReturnsNoItems() {
        // Setup
        when(mockUserMapper.selectList(any(Wrapper.class))).thenReturn(Collections.emptyList());

        // Run the test
        final List<User> result = userServiceImplUnderTest.getAllUsers();

        // Verify the results
        assertThat(result).isEqualTo(Collections.emptyList());
    }

    @Test
    void testAddUser() {
        // Setup
        final User user = new User();
        user.setId(0L);
        user.setName("name");
        user.setAge(0);
        user.setEmail("email");

        when(mockUserMapper.insert(new User())).thenReturn(0);

        // Run the test
        final int result = userServiceImplUnderTest.addUser(user);

        // Verify the results
        assertThat(result).isEqualTo(0);
    }

    @Test
    void testUpdateUser() {
        // Setup
        final User user = new User();
        user.setId(0L);
        user.setName("name");
        user.setAge(0);
        user.setEmail("email");

        when(mockUserMapper.updateById(new User())).thenReturn(0);

        // Run the test
        final int result = userServiceImplUnderTest.updateUser(user);

        // Verify the results
        assertThat(result).isEqualTo(0);
    }

    @Test
    void testDeleteUser() {
        // Setup
        when(mockUserMapper.deleteById(0L)).thenReturn(0);

        // Run the test
        final int result = userServiceImplUnderTest.deleteUser(0L);

        // Verify the results
        assertThat(result).isEqualTo(0);
    }

    @Test
    void testGetUsers() {
        // Setup
        final User user = new User();
        user.setId(0L);
        user.setName("name");
        user.setAge(0);
        user.setEmail("email");
        final List<User> expectedResult = Arrays.asList(user);

        // Configure UserMapper.selectList(...).
        final User user1 = new User();
        user1.setId(0L);
        user1.setName("name");
        user1.setAge(0);
        user1.setEmail("email");
        final List<User> users = Arrays.asList(user1);
        when(mockUserMapper.selectList(any(Wrapper.class))).thenReturn(users);

        // Run the test
        final List<User> result = userServiceImplUnderTest.getUsers();

        // Verify the results
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    void testGetUsers_UserMapperReturnsNoItems() {
        // Setup
        when(mockUserMapper.selectList(any(Wrapper.class))).thenReturn(Collections.emptyList());

        // Run the test
        final List<User> result = userServiceImplUnderTest.getUsers();

        // Verify the results
        assertThat(result).isEqualTo(Collections.emptyList());
    }
}
