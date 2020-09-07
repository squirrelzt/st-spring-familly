package com.stnacos.client;

import com.alibaba.nacos.api.NacosFactory;
import com.alibaba.nacos.api.config.ConfigService;
import com.alibaba.nacos.api.config.listener.Listener;
import com.alibaba.nacos.api.exception.NacosException;

import java.util.Properties;
import java.util.concurrent.Executor;

public class ConfigSdkDemo {
    public static void main(String[] args) throws NacosException, InterruptedException {
        String serverAddr = "localhost:8848";
        String dataId = "example";
        String group = "DEFAULT_GROUP";
        Properties properties = new Properties();
        properties.put("serverAddr", serverAddr);

        ConfigService configService = NacosFactory.createConfigService(properties);
        String context = configService.getConfig(dataId, group, 5000);
        System.out.println(context);
        Listener listener = new Listener() {
            @Override
            public Executor getExecutor() {
                return null;
            }

            @Override
            public void receiveConfigInfo(String s) {
                System.out.println("listener receive: " + s);
            }
        };

        configService.addListener(dataId, group, listener);

        boolean isPublishOk = configService.publishConfig(dataId, group, "info=java.sdk.content");
        System.out.println(isPublishOk);

        boolean isRemoveConfig = configService.removeConfig(dataId, group);
        System.out.println(isRemoveConfig);
        while (true) {
            Thread.sleep(10000);
        }
    }
}
