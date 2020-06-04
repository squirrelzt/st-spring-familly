package com.mybatis.startup;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.mybatis.mapper.UserMapper;
import com.mybatis.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;

@Slf4j
@Component
@Order(value = 5)
public class MyBatisStartUpRunner implements CommandLineRunner {
    @Autowired
    DataSource dataSource;
    @Autowired
    UserMapper userMapper;

    @Override
    public void run(String... args) throws Exception {
        log.info("-------------------");
        log.info("dataSource={}",dataSource.toString());
        Connection connection = dataSource.getConnection();
        log.info(connection.toString());
        User user = new User();
        user.setName("cat");
        user.setAge(25);
        userMapper.insert(user);
        QueryWrapper<User> queryWrapper = new QueryWrapper();
        userMapper.selectList(queryWrapper).forEach(row -> log.info(row.toString()));
        user.setName("Jams");
        user.setAge(30);
        userMapper.updateById(user);
        userMapper.selectList(queryWrapper).forEach(row -> log.info(row.toString()));
    }
}
