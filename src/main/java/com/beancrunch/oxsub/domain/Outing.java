package com.beancrunch.oxsub.domain;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

public class Outing {

    private DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");
    private final UUID uuid;
    private final String crew;
    private final SubType subRequired;
    private final Date date;

    public Outing(UUID uuid, String crew, SubType subRequired, Date date) {
        this.uuid = uuid;
        this.crew = crew;
        this.subRequired = subRequired;
        this.date = date;
    }

    public UUID getUuid() {
        return uuid;
    }

    public String getCrew() {
        return crew;
    }

    public String getSubRequired() {
        return subRequired.getValue();
    }

    public String getDate() {
        return dateFormat.format(date);
    }
}
