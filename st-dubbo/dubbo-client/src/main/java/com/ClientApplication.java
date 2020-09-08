package com;

import com.dubbo.server.ISayService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ClientApplication {
    public static void main(String[] args) {
        ISayService sayService = null;
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:META-INF/spring/application.xml");
        sayService = context.getBean(ISayService.class);
        System.out.println(sayService.say("client "));
    }
}
