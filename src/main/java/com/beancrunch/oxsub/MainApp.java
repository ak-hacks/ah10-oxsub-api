package com.beancrunch.oxsub;

import com.beancrunch.oxsub.resource.HelloWorldResource;
import io.dropwizard.Application;
import io.dropwizard.setup.Environment;

public class MainApp extends Application<AppConfig> {

    public void run(AppConfig appConfig, Environment environment) throws Exception {
        final HelloWorldResource helloWorldResource = new HelloWorldResource();
        environment.jersey().register(helloWorldResource);
    }

    public static void main(String[] args) throws Exception {
        new MainApp().run(args);
    }
}
