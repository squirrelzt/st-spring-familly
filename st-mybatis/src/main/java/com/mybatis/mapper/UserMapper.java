package com.mybatis.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mybatis.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserMapper extends BaseMapper<User> {
}
