package com.stmybatisenum.controller;

import com.stmybatisenum.model.Person;
import com.stmybatisenum.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PersonController {

    @Autowired
    PersonService personService;

    @GetMapping("query")
    public List<Person> query() {
        return personService.query();
    }

    @PostMapping("insert")
    public int insert(@RequestBody Person person) {
        return personService.insert(person);
    }
}
