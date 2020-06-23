package com.stnacos.controller;

import com.alibaba.nacos.api.config.annotation.NacosValue;
import com.alibaba.nacos.spring.context.annotation.config.NacosPropertySource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@NacosPropertySource(dataId = "example", groupId = "DEFAULT_GROUP", autoRefreshed = true)
@RestController
public class NacosConfigController {
    @NacosValue(value = "${info:hello Nacos}", autoRefreshed = true )
    private String info;

    @GetMapping("getInfo")
    private String getInfo() {
        return info;
    }
}
