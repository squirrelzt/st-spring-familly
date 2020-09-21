package com.dubbo;

import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.ws.rs.core.Response;

@DubboService(protocol = {"rest"})
public class SayHelloRestServiceImpl implements ISayHelloRestService {

    @Override
    @ResponseBody
    public Response sayHelloRest() {
        return Response.ok().entity("springboot dubbo rest protocol").build();
    }
}
