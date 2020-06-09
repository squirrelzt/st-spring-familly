package com.stmybatisenum.mapper;

import com.stmybatisenum.model.Person;
import java.util.List;

import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface PersonMapper {

//    @Select("select * from person")
    List<Person> query();

    int insert(Person person);
}