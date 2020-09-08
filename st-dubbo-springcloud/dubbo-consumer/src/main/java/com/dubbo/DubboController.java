package com.dubbo;

import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DubboController {

    @Reference
    ISayHelloService sayHelloService;

    @GetMapping("say")
    public String say() {
        return sayHelloService.sayHello(" dubbo");
    }
}
