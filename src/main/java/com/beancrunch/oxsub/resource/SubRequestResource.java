package com.beancrunch.oxsub.resource;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URI;

@Path("/find-a-sub")
public class SubRequestResource {

    private String onCompletionRedirectUrl;

    public SubRequestResource(String onCompletionRedirectUrl) {
        this.onCompletionRedirectUrl = onCompletionRedirectUrl;
    }

    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public Response submitSubRequest(@FormParam("crew") String crew) {
        System.out.println("crew :: " + crew);
        return Response.seeOther(URI.create(onCompletionRedirectUrl)).build();
    }
}
