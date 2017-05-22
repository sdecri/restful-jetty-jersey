/**
 * Test.java
 */
package com.sdc.web.ws;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * @author simone.decristofaro
 * May 22, 2017
 */
@Path("/test")
public class Test extends Application{

    @GET
    @Path("/hello")
    @Produces(MediaType.TEXT_PLAIN)
    public Response hello(@QueryParam("name") @DefaultValue("World") String name,@Context HttpServletRequest request) {
        
        String responseMessage = String.format("Hello %s!", name);
        
        return Response.status(Response.Status.BAD_REQUEST)
                .entity(responseMessage)
                .build();
        
    }
    
    
}
