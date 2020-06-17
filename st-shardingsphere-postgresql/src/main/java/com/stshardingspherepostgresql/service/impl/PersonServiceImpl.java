package com.stshardingspherepostgresql.service.impl;

import com.stshardingspherepostgresql.mapper.PersonMapper;
import com.stshardingspherepostgresql.model.Person;
import com.stshardingspherepostgresql.model.PersonExample;
import com.stshardingspherepostgresql.service.PersonService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class PersonServiceImpl implements PersonService {
    @Autowired
    PersonMapper personMapper;

    @Override
    public List<Person> select() {
        PersonExample example = new PersonExample();
        return personMapper.selectByExample(example);
    }
}
