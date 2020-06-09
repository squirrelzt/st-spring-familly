package com.stmybatisenum.service;

import com.stmybatisenum.model.Person;

import java.util.List;

public interface PersonService {
    List<Person> query();

    Person queryById(Integer id);

    int insert(Person person);

    int insertOne(Person person);
}
