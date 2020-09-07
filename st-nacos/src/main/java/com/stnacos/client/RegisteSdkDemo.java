package com.stnacos.client;

import com.alibaba.nacos.api.exception.NacosException;
import com.alibaba.nacos.api.naming.NamingFactory;
import com.alibaba.nacos.api.naming.NamingService;
import com.alibaba.nacos.api.naming.pojo.Cluster;
import com.alibaba.nacos.api.naming.pojo.Instance;
import com.alibaba.nacos.api.naming.pojo.Service;
import com.alibaba.nacos.api.naming.pojo.healthcheck.AbstractHealthChecker;

import java.util.HashMap;
import java.util.Map;

public class RegisteSdkDemo {
    public static void main(String[] args) throws NacosException, InterruptedException {
        String serverAddr = "localhost:8848";
//        NamingService naming = NamingFactory.createNamingService(System.getProperty("serveAddr"));
        NamingService naming = NamingFactory.createNamingService(serverAddr);
        naming.registerInstance("nacos.test.3", "11.11.11.11", 8888, "TEST1");

        Instance instance = new Instance();
        instance.setIp("55.55.55.55");
        instance.setPort(9999);
        instance.setHealthy(false);
        instance.setWeight(2.0);
        Map<String, String> instanceMeta = new HashMap<>();
        instanceMeta.put("site", "et2");
        instance.setMetadata(instanceMeta);

        instance.setServiceName("nacos.test.4");
        instance.setEnabled(true);
        instance.addMetadata("symmetricCall", "true");

        instance.setClusterName("TEST5");
        instance.setEphemeral(true);

        naming.registerInstance("nacos.test.4", instance);

        while (true) {
            Thread.sleep(10000);
        }
    }
}
