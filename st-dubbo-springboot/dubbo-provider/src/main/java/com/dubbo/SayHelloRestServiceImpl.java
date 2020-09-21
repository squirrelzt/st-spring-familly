package com.dubbo;

import com.dubbo.domain.Person;
import com.dubbo.domain.Response;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboService;

@Slf4j
@DubboService(protocol = {"rest"})
public class SayHelloRestServiceImpl implements ISayHelloRestService {

    @Override
    public Response sayHelloRest(String param1, String param2) {
        log.info("param1={},param2={}", param1, param2);
        Person person = new Person();
        person.setName("tom");
        person.setAge(30);
        person.setGender("man");
        Response response = new Response();
        response.setCode("200");
        response.setMsg(param1 + " " + param2);
        response.setData(person);
        return response;
    }
}
