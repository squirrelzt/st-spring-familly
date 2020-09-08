package com.dubbo.controller;

import com.dubbo.ISayHelloService;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class DubboController {

    @DubboReference
    ISayHelloService sayHelloService;

    @GetMapping("say")
    public String say() {
        return sayHelloService.sayHello(" dubbo rpc");
    }
}
