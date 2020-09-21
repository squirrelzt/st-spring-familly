package com.dubbo;

import com.dubbo.domain.Person;
import com.dubbo.domain.Response;
import org.apache.dubbo.config.annotation.DubboService;

@DubboService(protocol = {"rest"})
public class SayHelloRestServiceImpl implements ISayHelloRestService {

    @Override
    public Response sayHelloRest() {
        Person person = new Person();
        person.setName("tom");
        person.setAge(30);
        person.setGender("man");
        Response response = new Response();
        response.setCode("200");
        response.setMsg("成功");
        response.setData(person);
        return response;
    }
}
