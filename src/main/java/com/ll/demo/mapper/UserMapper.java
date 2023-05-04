package com.ll.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ll.demo.entity.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper extends BaseMapper<User> {
}
