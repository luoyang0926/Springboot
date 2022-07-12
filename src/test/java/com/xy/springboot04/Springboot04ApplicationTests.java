package com.xy.springboot04;

import com.xy.springboot04.Mapper.UserMapper;
import com.xy.springboot04.pojo.User;
import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
@Slf4j
@SpringBootTest
class Springboot04ApplicationTests {
     @Autowired
    DataSource dataSource;
     @Autowired
    UserMapper userMapper;


    @Test
    void contextLoads() {

        log.info("类型:"+dataSource.getClass());
    }

    @Test
    void testUserMapper() {
        User user = userMapper.selectById(1);
        log.info("用户信息："+user);
    }
}
