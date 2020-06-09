package com.stmybatisenum.service;

import com.stmybatisenum.model.Person;

import java.util.List;

public interface PersonService {
    List<Person> query();

    int insert(Person person);
}
