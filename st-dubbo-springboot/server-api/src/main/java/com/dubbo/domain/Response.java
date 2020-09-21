package com.dubbo.domain;

import lombok.Data;

import java.io.Serializable;

@Data
public class Response<T> implements Serializable {

    private String code;
    private String msg;
    private T data;
}
