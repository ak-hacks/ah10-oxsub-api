package com.beancrunch.oxsub;

import com.beancrunch.oxsub.resource.HelloWorldResource;
import com.beancrunch.oxsub.resource.OutingsResource;
import io.dropwizard.Application;
import io.dropwizard.setup.Environment;

public class MainApp extends Application<AppConfig> {

    public void run(AppConfig appConfig, Environment environment) throws Exception {
        final HelloWorldResource helloWorldResource = new HelloWorldResource();
        final OutingsResource outingsResource = new OutingsResource();
        environment.jersey().register(helloWorldResource);
        environment.jersey().register(outingsResource);
    }

    public static void main(String[] args) throws Exception {
        new MainApp().run(args);
    }
}
