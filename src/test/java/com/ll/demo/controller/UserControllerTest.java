package com.ll.demo.controller;

import cn.hutool.json.JSONUtil;
import com.baomidou.mybatisplus.test.autoconfigure.AutoConfigureMybatisPlus;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.PageInfo;
import com.ll.demo.common.R;
import com.ll.demo.dto.PageDto;
import com.ll.demo.entity.User;
import com.ll.demo.service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@ExtendWith(SpringExtension.class)
@WebMvcTest(UserController.class)
@AutoConfigureMybatisPlus
class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService mockUserService;

    @Test
    void testUser() throws Exception {
        // Setup
        // Configure UserService.getUserById(...).
        final User user = new User();
        user.setId(0L);
        user.setName("name");
        user.setAge(0);
        user.setEmail("email");
        when(mockUserService.getUserById(1L)).thenReturn(user);

        // Run the test
        final MockHttpServletResponse response = mockMvc.perform(get("/user/user")
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        // Verify the results
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        String expected = JSONUtil.toJsonStr(JSONUtil.parseObj(R.success(user), false));
        System.out.println(expected);
        assertThat(response.getContentAsString()).isEqualTo(expected);
    }

    @Test
    void testAll() throws Exception {
        // Setup
        // Configure UserService.getAllUsers(...).
        final User user = new User();
        user.setId(0L);
        user.setName("name");
        user.setAge(0);
        user.setEmail("email");
        final List<User> users = Arrays.asList(user);
        when(mockUserService.getAllUsers()).thenReturn(users);

        // Run the test
        final MockHttpServletResponse response = mockMvc.perform(get("/user/allUser")
                        .param("pageNo", "0")
                        .param("pageSize", "0")
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        // Verify the results
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.getContentAsString()).isEqualTo("expectedResponse");
    }

    @Test
    void testAll_UserServiceReturnsNoItems() throws Exception {
        // Setup
        when(mockUserService.getAllUsers()).thenReturn(Collections.emptyList());

        // Run the test
        final MockHttpServletResponse response = mockMvc.perform(get("/user/allUser")
                        .param("pageNo", "0")
                        .param("pageSize", "0")
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        // Verify the results
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.getContentAsString()).isEqualTo("expectedResponse");
    }

    @Test
    void testAllObjetc() throws Exception {
        // Setup
        // Configure UserService.getAllUsers(...).
        final User user = new User();
        user.setId(0L);
        user.setName("name");
        user.setAge(0);
        user.setEmail("email");
        final List<User> users = Arrays.asList(user);
        when(mockUserService.getAllUsers()).thenReturn(users);

        // Run the test
        final MockHttpServletResponse response = mockMvc.perform(get("/user/allUser22")
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        // Verify the results
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.getContentAsString()).isEqualTo("expectedResponse");
    }

    @Test
    void testAllObjetc_UserServiceReturnsNoItems() throws Exception {
        // Setup
        when(mockUserService.getAllUsers()).thenReturn(Collections.emptyList());

        // Run the test
        final MockHttpServletResponse response = mockMvc.perform(get("/user/allUser22")
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        // Verify the results
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.getContentAsString()).isEqualTo("expectedResponse");
    }

    @Test
    void testPostUsers() throws Exception {
        // Setup
        // Configure UserService.getAllUsers(...).
        final User user = new User();
        user.setId(0L);
        user.setName("name");
        user.setAge(0);
        user.setEmail("email");
        final List<User> users = Arrays.asList(user);
        when(mockUserService.getAllUsers()).thenReturn(users);

        // Run the test
        final MockHttpServletResponse response = mockMvc.perform(post("/user/postUsers")
                        .content("content").contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        // Verify the results
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.getContentAsString()).isEqualTo("expectedResponse");
    }

    @Test
    void testPostUsers_UserServiceReturnsNoItems() throws Exception {
        // Setup
        when(mockUserService.getAllUsers()).thenReturn(Collections.emptyList());


        PageDto pageDto = new PageDto(1, 2, "占位");
        String content = JSONUtil.toJsonStr(JSONUtil.parseObj(pageDto, true));
        // Run the test
        final MockHttpServletResponse response = mockMvc.perform(post("/user/postUsers")
                        .content(content).contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        // Verify the results
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
//        String expected = JSONUtil.toJsonStr(JSONUtil.parseObj(R.success(new PageInfo<>()), false));
        String expected = new ObjectMapper().writeValueAsString(R.success(new PageInfo<>())); // json序列化的顺序不一样
        assertThat(response.getContentAsString()).isEqualTo(expected);
    }
}
