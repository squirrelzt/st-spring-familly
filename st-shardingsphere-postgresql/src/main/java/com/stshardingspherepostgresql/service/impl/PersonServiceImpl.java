package com.stshardingspherepostgresql.service.impl;

import com.stshardingspherepostgresql.mapper.PersonMapper;
import com.stshardingspherepostgresql.model.Person;
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
//        PersonExample example = new PersonExample();
//        PersonExample.Criteria criteria = example.createCriteria();
//        criteria.andIdBetween(1, 25);
//        criteria.andAgeGreaterThan(50);
//        return personMapper.selectByExample(example);
        return personMapper.selectTwo();
    }

    @Override
    public void insert() {
        for (int i = 0; i < 2; i++) {
            Person person = new Person();
            if (i == 0) {
                person.setId(40);
                person.setName("one");
                person.setAge(38);
            } else if (i == 1) {
                person.setId(41);
                person.setName("two");
                person.setAge(48);
            }
            personMapper.insertSelective(person);
        }
    }
}
