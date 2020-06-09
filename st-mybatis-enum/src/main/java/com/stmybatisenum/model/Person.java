package com.stmybatisenum.model;

import com.stmybatisenum.enums.GenderEnum;
import lombok.Data;

import java.io.Serializable;

@Data
public class Person implements Serializable {

    private Integer id;

    private String name;

    private Integer age;

    private GenderEnum gender;

}