package com.stmybatisenum.service.impl;

import com.stmybatisenum.mapper.PersonMapper;
import com.stmybatisenum.model.Person;
import com.stmybatisenum.service.PersonService;
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
    public List<Person> query() {
        return personMapper.query();
    }

    @Override
    public Person queryById(Integer id) {
        List<Person> list = personMapper.queryById(id);
        if (list.size() > 0) {
            return list.get(0);
        }
        return null;
    }

    @Override
    public int insert(Person person) {
        return personMapper.insert(person);
    }

    @Override
    public int insertOne(Person person) {
        return personMapper.insertOne(person);
    }
}
