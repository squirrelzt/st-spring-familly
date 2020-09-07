package com.stnacos.controller;

import com.alibaba.nacos.api.annotation.NacosInjected;
import com.alibaba.nacos.api.exception.NacosException;
import com.alibaba.nacos.api.naming.NamingService;
import com.alibaba.nacos.api.naming.pojo.Instance;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RequestMapping("discovery")
@RestController
public class NacosDiscoveryController {

    @NacosInjected
    NamingService namingService;

    @GetMapping("get")
    public List<Instance> get(@RequestParam String serviceName) throws NacosException {
        return namingService.getAllInstances(serviceName);
    }

    @PostMapping("/register")
    public void register() throws NacosException {
        Instance instance=new Instance();
        instance.setHealthy(true);
//        instance.setEnabled(true);
//        instance.setEphemeral(true);  //临时节点/持久化节点, CP（Raft）, AP（Distro）
        instance.setIp("192.168.3.6");
        instance.setPort(8888);
        instance.setWeight(10);  //1~100
        namingService.registerInstance("my-nacos",instance);
    }
}
