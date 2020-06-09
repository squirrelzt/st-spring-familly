package com.stmybatisenum.mapper;

import com.stmybatisenum.enums.GenderEnum;
import com.stmybatisenum.enums.ZipCodeEnum;
import com.stmybatisenum.handler.ZipCodeEnumHandler;
import com.stmybatisenum.model.Person;
import java.util.List;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.EnumTypeHandler;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface PersonMapper {

    @Results({
            @Result(column = "id", property = "id", javaType = Integer.class),
            @Result(column = "name", property = "name", javaType = String.class),
            @Result(column = "age", property = "age", javaType = Integer.class),
            @Result(column = "gender", property = "gender", javaType = GenderEnum.class, typeHandler = EnumTypeHandler.class),
            @Result(column = "zipCode", property = "zip_code", javaType = ZipCodeEnum.class, typeHandler = ZipCodeEnumHandler.class)
    })
    @Select("select * from person where id = #{id}")
    List<Person> queryById(Integer id);

    List<Person> query();

    int insertOne(Person person);

    @Insert("insert into person(id, name, age, gender, zip_code) values (#{id},#{name},#{age},#{gender},#{zipCode})")
    int insert(Person person);
}