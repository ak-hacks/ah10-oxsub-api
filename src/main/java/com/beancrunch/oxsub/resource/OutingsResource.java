package com.beancrunch.oxsub.resource;

import com.beancrunch.oxsub.domain.Outing;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/outings")
@Produces(MediaType.APPLICATION_JSON)
public class OutingsResource {

    private List<Outing> outings;

    public OutingsResource(List<Outing> outings) {
        this.outings = outings;
    }

    @GET
    public List<Outing> getOutings() {
        return outings;
    }
}
