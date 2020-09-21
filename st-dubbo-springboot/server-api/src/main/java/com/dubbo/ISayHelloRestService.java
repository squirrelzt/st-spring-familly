package com.dubbo;

import com.dubbo.domain.Response;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/say")
public interface ISayHelloRestService {

    @POST
    @Path("/helloRest")
    @Produces({MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_JSON})
    Response sayHelloRest();
}
