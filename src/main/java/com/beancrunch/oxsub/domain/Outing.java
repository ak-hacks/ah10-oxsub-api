package com.beancrunch.oxsub.domain;

import java.util.Date;
import java.util.UUID;

public class Outing {

    private final UUID uuid;
    private final String crew;
    private final String subRequired;
    private final String date;

    public Outing(UUID uuid, String crew, String subRequired, String date) {
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
        return subRequired;
    }

    public String getDate() {
        return date;
    }
}
