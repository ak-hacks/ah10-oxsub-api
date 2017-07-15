package com.beancrunch.oxsub;

import com.beancrunch.oxsub.resource.HelloWorldResource;
import com.beancrunch.oxsub.resource.OutingsResource;
import com.beancrunch.oxsub.resource.SubRequestResource;
import io.dropwizard.Application;
import io.dropwizard.configuration.EnvironmentVariableSubstitutor;
import io.dropwizard.configuration.SubstitutingSourceProvider;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import org.eclipse.jetty.servlets.CrossOriginFilter;

import javax.servlet.DispatcherType;
import javax.servlet.FilterRegistration;
import java.util.EnumSet;

public class MainApp extends Application<AppConfig> {

    @Override
    public void initialize(Bootstrap<AppConfig> bootstrap) {
        bootstrap.setConfigurationSourceProvider(
                new SubstitutingSourceProvider(bootstrap.getConfigurationSourceProvider(),
                        new EnvironmentVariableSubstitutor(false)
                )
        );
    }

    public void run(AppConfig appConfig, Environment environment) throws Exception {

        final FilterRegistration.Dynamic cors =
                environment.servlets().addFilter("CORS", CrossOriginFilter.class);
        cors.setInitParameter("allowedOrigins", "*");
        cors.setInitParameter("allowedHeaders", "X-Requested-With,Content-Type,Accept,Origin");
        cors.setInitParameter("allowedMethods", "OPTIONS,GET,PUT,POST,DELETE,HEAD");
        cors.addMappingForUrlPatterns(EnumSet.allOf(DispatcherType.class), true, "/*");

        final HelloWorldResource helloWorldResource = new HelloWorldResource();
        final OutingsResource outingsResource = new OutingsResource();
        final SubRequestResource subRequestResource = new SubRequestResource(appConfig.getHomepageAbsoluteUrl());
        environment.jersey().register(helloWorldResource);
        environment.jersey().register(outingsResource);
        environment.jersey().register(subRequestResource);
    }

    public static void main(String[] args) throws Exception {
        new MainApp().run(args);
    }
}
