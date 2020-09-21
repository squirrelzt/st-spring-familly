package com.dubbo.domain;

import lombok.Data;

import java.io.Serializable;

@Data
public class Person implements Serializable {
    private String name;
    private Integer age;
    private String gender;
}
