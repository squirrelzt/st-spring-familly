package com.stshardingspherepostgresql.service;

import com.stshardingspherepostgresql.model.Person;

import java.util.List;

public interface PersonService {
    List<Person> select();
}
