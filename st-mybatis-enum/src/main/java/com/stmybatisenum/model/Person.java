package com.stmybatisenum.model;

import com.stmybatisenum.enums.GenderEnum;
import com.stmybatisenum.enums.GradeEnum;
import com.stmybatisenum.enums.HasCarEnum;
import com.stmybatisenum.enums.ZipCodeEnum;
import lombok.Data;

import java.io.Serializable;

@Data
public class Person implements Serializable {

    private Integer id;

    private String name;

    private Integer age;

    private GenderEnum gender;

    private HasCarEnum hasCar;

    private GradeEnum grade;

    private ZipCodeEnum zipCode;
}