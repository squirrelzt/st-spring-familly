package com.stshardingspherepostgresql.controller;

import com.stshardingspherepostgresql.model.Person;
import com.stshardingspherepostgresql.service.PersonService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
public class PersonController {

    @Autowired
    PersonService personService;

    @GetMapping("select")
    public List<Person> select() {
        return personService.select();
    }
}
