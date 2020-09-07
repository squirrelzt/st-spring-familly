package com.stnacos.controller;

import com.alibaba.nacos.api.config.annotation.NacosValue;
import com.alibaba.nacos.spring.context.annotation.config.NacosPropertySource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@NacosPropertySource(dataId = "example", groupId = "DEFAULT_GROUP", autoRefreshed = true)
@RestController
public class NacosConfigController {

    @NacosValue(value = "${info:hello Nacos}", autoRefreshed = true )
    private String info;

    @GetMapping("getInfo")
    private String getInfo() {
        log.info("info={}", info);
        return info;
    }
}
