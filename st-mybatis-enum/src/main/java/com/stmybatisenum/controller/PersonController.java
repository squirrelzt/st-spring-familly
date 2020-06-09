package com.stmybatisenum.controller;

import com.stmybatisenum.model.Person;
import com.stmybatisenum.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PersonController {

    @Autowired
    PersonService personService;

    @GetMapping("query")
    public List<Person> query() {
        return personService.query();
    }

    @GetMapping("queryById")
    public Person query(@RequestParam Integer id) {
        return personService.queryById(id);
    }

    @PostMapping("insert")
    public int insert(@RequestBody Person person) {
        return personService.insert(person);
    }

    @PostMapping("insertOne")
    public int insertOne(@RequestBody Person person) {
        return personService.insert(person);
    }
}
