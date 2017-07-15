package com.beancrunch.oxsub;

import io.dropwizard.Configuration;

public class AppConfig extends Configuration {

    private String homepageAbsoluteUrl;

    public String getHomepageAbsoluteUrl() {
        return homepageAbsoluteUrl;
    }

    public void setHomepageAbsoluteUrl(String homepageAbsoluteUrl) {
        this.homepageAbsoluteUrl = homepageAbsoluteUrl;
    }
}
