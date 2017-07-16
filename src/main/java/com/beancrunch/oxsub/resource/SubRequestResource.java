package com.beancrunch.oxsub.resource;

import com.beancrunch.oxsub.domain.Outing;
import com.beancrunch.oxsub.domain.SubType;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URI;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.*;

@Path("/find-a-sub")
public class SubRequestResource {

    private final String onCompletionRedirectUrl;
    private final List<Outing> outings;
    private final DateFormat dateFormat;

    public SubRequestResource(List<Outing> outings, String onCompletionRedirectUrl, DateFormat dateFormat) {
        this.onCompletionRedirectUrl = onCompletionRedirectUrl;
        this.outings = outings;
        this.dateFormat = dateFormat;
    }

    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public Response submitSubRequest(@FormParam("subType") String subType,
                                     @FormParam("crew") String crew,
                                     @FormParam("date") String date) throws ParseException {
        System.out.println("subTime :: " + subType);
        System.out.println("crew :: " + crew);
        System.out.println("date :: " + date);
        addOutingToDb(subType, crew, date);
        return Response.seeOther(URI.create(onCompletionRedirectUrl)).build();
    }

    private void addOutingToDb(String subType, String crew, String date) throws ParseException {
        Outing outing = new Outing(UUID.randomUUID(), crew, SubType.valueOf(subType), dateFormat.parse(date));
        outings.add(outing);
        outings.sort((o1, o2) -> {
            try {
                Date d1 = dateFormat.parse(o1.getDate());
                Date d2 = dateFormat.parse(o2.getDate());
                // TODO: invert after ah demo
                return d1.after(d2) ? -1 : 1;
            } catch (ParseException e) {
                e.printStackTrace();
                return 1;
            }
        });
    }
}
