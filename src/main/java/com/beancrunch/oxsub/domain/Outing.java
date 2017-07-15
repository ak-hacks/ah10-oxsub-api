package com.beancrunch.oxsub.domain;

import java.util.UUID;

public class Outing {

    private final UUID uuid;
    private final String crew;
    private final SubType subRequired;
    private final String date;

    public Outing(UUID uuid, String crew, SubType subRequired, String date) {
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

    public SubType getSubRequired() {
        return subRequired;
    }

    public String getDate() {
        return date;
    }
}
