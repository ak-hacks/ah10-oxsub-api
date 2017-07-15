package com.beancrunch.oxsub.resource;

import com.beancrunch.oxsub.domain.Outing;
import com.beancrunch.oxsub.domain.SubType;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Path("/outings")
@Produces(MediaType.APPLICATION_JSON)
public class OutingsResource {

    @GET
    public List<Outing> getOutings() {
        return getDemoOutings();
    }

    private List<Outing> getDemoOutings() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");
        Outing outing1 = new Outing(UUID.randomUUID(), "Christ Church M2", SubType.ROWER, dateFormat.format(new Date()));
        Outing outing2 = new Outing(UUID.randomUUID(), "St Johns W1", SubType.ROWER, dateFormat.format(new Date()));
        Outing outing3 = new Outing(UUID.randomUUID(), "Catz M3", SubType.BOWSIDEROWER, dateFormat.format(new Date()));
        Outing outing4 = new Outing(UUID.randomUUID(), "Balliol W2", SubType.ROWER, dateFormat.format(new Date()));
        Outing outing5 = new Outing(UUID.randomUUID(), "Trinity M2", SubType.STOKESIDEROWER, dateFormat.format(new Date()));
        Outing outing6 = new Outing(UUID.randomUUID(), "Christ Church W2", SubType.SSTATUSCOX, dateFormat.format(new Date()));
        Outing outing7 = new Outing(UUID.randomUUID(), "Worcester W1", SubType.COX, dateFormat.format(new Date()));

        List<Outing> outings = new ArrayList<>();
        outings.add(outing1);
        outings.add(outing2);
        outings.add(outing3);
        outings.add(outing4);
        outings.add(outing5);
        outings.add(outing6);
        outings.add(outing7);

        return outings;
    }

}
