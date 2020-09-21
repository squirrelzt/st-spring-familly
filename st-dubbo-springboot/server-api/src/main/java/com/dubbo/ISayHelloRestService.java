package com.dubbo;

import com.dubbo.domain.BaseRequest;
import com.dubbo.domain.BaseResponse;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/say")
public interface ISayHelloRestService {

    @GET
    @Path("/helloRest/{param1}")
    @Produces({MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_JSON})
    BaseResponse sayHelloRest(@PathParam("param1") String param1, @QueryParam("param2") String param2);

    @POST
    @Path("post")
    @Produces({MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_JSON})
    BaseResponse sayHelloRestPost(BaseRequest baseRequest);
}
