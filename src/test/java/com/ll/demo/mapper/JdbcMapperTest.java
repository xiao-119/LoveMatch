package com.ll.demo.mapper;

import com.baomidou.mybatisplus.test.autoconfigure.AutoConfigureMybatisPlus;
import com.zaxxer.hikari.HikariDataSource;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@Slf4j
@SpringBootTest
@AutoConfigureMybatisPlus
@MapperScan("org.ll.review.mapper")
public class JdbcMapperTest {
    @Autowired
    private JdbcMapper jdbcMapper;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Test
    @Disabled
    public void testSelectAll() {
        log.info("{}", jdbcMapper.selectAll("user"));
    }



    // skip 跳过测试
//    @Test
//    public void queryDataSource(){
//        DataSource dataSource = jdbcTemplate.getDataSource();
//        System.out.println(dataSource);
//        if (dataSource instanceof HikariDataSource hikariDataSource){
//            System.out.println(hikariDataSource.getJdbcUrl());
//            System.out.println(hikariDataSource.getUsername());
//            System.out.println(hikariDataSource.getPassword());
//        }
//    }
}
