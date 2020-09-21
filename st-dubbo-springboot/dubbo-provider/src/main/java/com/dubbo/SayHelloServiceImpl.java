package com.dubbo;

import org.apache.dubbo.config.annotation.DubboService;

@DubboService(protocol = "dubbo")
public class SayHelloServiceImpl implements ISayHelloService {

    @Override
    public String sayHello(String msg) {
        return "spring boot dubbo " + msg;
    }
}
