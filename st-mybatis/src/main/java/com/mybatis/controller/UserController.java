package com.mybatis.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.mybatis.mapper.UserMapper;
import com.mybatis.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    UserMapper userMapper;

    @GetMapping("query")
    public List<User> query() {
        QueryWrapper<User> queryWrapper = new QueryWrapper();
        return userMapper.selectList(queryWrapper);
    }
    @PostMapping("insert")
    public boolean insert(@RequestBody User user) {
        int count = userMapper.insert(user);
        QueryWrapper<User> queryWrapper = new QueryWrapper();
        userMapper.selectList(queryWrapper).forEach(row -> log.info(row.toString()));
        if (1 == count) {
            return true;
        } else {
            return false;
        }
    }

    @PostMapping("updateById")
    public boolean updateById(@RequestBody User user) {
        String id = user.getId();
        if (StringUtils.isEmpty(id)) {
            return false;
        }
        int count = userMapper.updateById(user);
        QueryWrapper<User> queryWrapper = new QueryWrapper();
        userMapper.selectList(queryWrapper).forEach(row -> log.info(row.toString()));
        if (1 == count) {
            return true;
        } else {
            return false;
        }
    }
}
