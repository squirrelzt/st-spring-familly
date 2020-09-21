package com.dubbo;

import com.dubbo.domain.Response;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/say")
public interface ISayHelloRestService {

    @GET
    @Path("/helloRest/{param1}")
    @Produces({MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_JSON})
    Response sayHelloRest(@PathParam("param1") String param1, @QueryParam("param2") String param2);
}
