package com.ll.demo.mapper;


import cn.hutool.core.util.ObjectUtil;
import com.ll.demo.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Slf4j
@Repository
public class JdbcMapper {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<?> selectAll(String tableName) {
        if (ObjectUtil.isEmpty(tableName)) {
            return List.of();
        }
        String sql = "SELECT * FROM " + tableName;
        List<User> query = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(User.class));
        log.info("{}", query.size());
        return query;
    }

}
