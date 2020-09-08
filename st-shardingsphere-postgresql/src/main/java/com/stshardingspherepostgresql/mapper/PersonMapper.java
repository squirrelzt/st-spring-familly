package com.stshardingspherepostgresql.mapper;

import java.util.List;

import com.stshardingspherepostgresql.model.Person;
import com.stshardingspherepostgresql.model.PersonExample;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface PersonMapper {

    List<Person> selectTwo();

    long countByExample(PersonExample example);

    int deleteByExample(PersonExample example);

    @Insert({
        "insert into t_person (id, name, ",
        "age)",
        "values (#{id,jdbcType=INTEGER}, #{name,jdbcType=VARCHAR}, ",
        "#{age,jdbcType=INTEGER})"
    })
    int insert(Person record);

    int insertSelective(Person record);

    List<Person> selectByExampleWithRowbounds(PersonExample example, RowBounds rowBounds);

    List<Person> selectByExample(PersonExample example);

    int updateByExampleSelective(@Param("record") Person record, @Param("example") PersonExample example);

    int updateByExample(@Param("record") Person record, @Param("example") PersonExample example);
}