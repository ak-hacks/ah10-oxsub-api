package com.beancrunch.oxsub;

import com.beancrunch.oxsub.resource.HelloWorldResource;
import com.beancrunch.oxsub.resource.OutingsResource;
import io.dropwizard.Application;
import io.dropwizard.setup.Environment;
import org.eclipse.jetty.servlets.CrossOriginFilter;

import javax.servlet.DispatcherType;
import javax.servlet.FilterRegistration;
import java.util.EnumSet;

public class MainApp extends Application<AppConfig> {

    public void run(AppConfig appConfig, Environment environment) throws Exception {
        final FilterRegistration.Dynamic cors =
                environment.servlets().addFilter("CORS", CrossOriginFilter.class);
        cors.setInitParameter("allowedOrigins", "*");
        cors.setInitParameter("allowedHeaders", "X-Requested-With,Content-Type,Accept,Origin");
        cors.setInitParameter("allowedMethods", "OPTIONS,GET,PUT,POST,DELETE,HEAD");
        cors.addMappingForUrlPatterns(EnumSet.allOf(DispatcherType.class), true, "/*");

        final HelloWorldResource helloWorldResource = new HelloWorldResource();
        final OutingsResource outingsResource = new OutingsResource();
        environment.jersey().register(helloWorldResource);
        environment.jersey().register(outingsResource);
    }

    public static void main(String[] args) throws Exception {
        new MainApp().run(args);
    }
}
