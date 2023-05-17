package com.ll.demo.mapper;

import com.baomidou.mybatisplus.test.autoconfigure.AutoConfigureMybatisPlus;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest
@AutoConfigureMybatisPlus
@MapperScan("org.ll.review.mapper")
public class JdbcMapperTest {
    @Autowired
    private JdbcMapper jdbcMapper;

    @Test
    public void testSelectAll() {
        log.info("{}", jdbcMapper.selectAll("user"));
    }
}
