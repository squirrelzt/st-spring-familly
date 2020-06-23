package com.stnacos.client;

import com.alibaba.nacos.api.NacosFactory;
import com.alibaba.nacos.api.config.ConfigService;
import com.alibaba.nacos.api.exception.NacosException;

import java.util.Properties;

public class NacosSdkDemo {
    public static void main(String[] args) {
        String serverAddr = "localhost:8848";
        String dataId = "example";
        String groupId = "DEFAULT_GROUP";
        Properties properties = new Properties();
        properties.put("serverAddr", serverAddr);

        try {
            ConfigService configService = NacosFactory.createConfigService(properties);
            String context = configService.getConfig(dataId, groupId, 3000);
            System.out.println(context);
        } catch (NacosException e) {
            e.printStackTrace();
        }
    }
}
