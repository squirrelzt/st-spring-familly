package com.dubbo.server;

public class SayServiceImpl implements ISayService {
    @Override
    public String say(String str) {
        return str + "my dubbo";
    }
}
