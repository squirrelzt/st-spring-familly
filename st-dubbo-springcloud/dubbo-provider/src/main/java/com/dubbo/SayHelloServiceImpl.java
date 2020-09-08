package com.dubbo;

import org.apache.dubbo.config.annotation.Service;

@Service
public class SayHelloServiceImpl implements ISayHelloService {

    @Override
    public String sayHello(String msg) {
        return "spring cloud " + msg;
    }
}
