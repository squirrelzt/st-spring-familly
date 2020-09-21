package com.dubbo;

import com.dubbo.domain.BaseRequest;
import com.dubbo.domain.BaseResponse;
import com.dubbo.domain.Person;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboService;

@Slf4j
@DubboService(protocol = {"rest"})
public class SayHelloRestServiceImpl implements ISayHelloRestService {

    @Override
    public BaseResponse sayHelloRest(String param1, String param2) {
        log.info("param1={},param2={}", param1, param2);
        Person person = new Person();
        person.setName("tom");
        person.setAge(30);
        person.setGender("man");
        BaseResponse response = new BaseResponse();
        response.setCode("200");
        response.setMsg(param1 + " " + param2);
        response.setData(person);
        return response;
    }

    @Override
    public BaseResponse sayHelloRestPost(BaseRequest baseRequest) {
        String param1 = baseRequest.getParam1();
        String param2 = baseRequest.getParam2();
        String param3 = baseRequest.getParam3();
        log.info("bbaseRequest:param1={},param2={},param3={}", param1, param2, param3);
        Person person = new Person();
        person.setName("tom");
        person.setAge(30);
        person.setGender("man");
        BaseResponse response = new BaseResponse();
        response.setCode("200");
        response.setMsg(param1 + " " + param2 + " " + param3);
        response.setData(person);
        return response;
    }
}
