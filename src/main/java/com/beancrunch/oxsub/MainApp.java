package com.beancrunch.oxsub;

import com.beancrunch.oxsub.domain.Outing;
import com.beancrunch.oxsub.domain.SubType;
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
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

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

        // Temp in-memory store of outings
        List<Outing> outings = new ArrayList<>();
        outings.addAll(getDemoOutings());

        final DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");
        final HelloWorldResource helloWorldResource = new HelloWorldResource();
        final OutingsResource outingsResource = new OutingsResource(outings);
        final SubRequestResource subRequestResource = new SubRequestResource(
                outings,
                appConfig.getHomepageAbsoluteUrl()+"?find-a-sub-request-status=true",
                dateFormat);
        environment.jersey().register(helloWorldResource);
        environment.jersey().register(outingsResource);
        environment.jersey().register(subRequestResource);
    }

    public static void main(String[] args) throws Exception {
        new MainApp().run(args);
    }

    private List<Outing> getDemoOutings() {
        List<Outing> outings = new ArrayList<>();
        Outing outing1 = new Outing(UUID.randomUUID(), "Christ Church M2", SubType.ROWER, new Date());
        Outing outing2 = new Outing(UUID.randomUUID(), "St Johns W1", SubType.ROWER, new Date());
        Outing outing3 = new Outing(UUID.randomUUID(), "Catz M3", SubType.BOWSIDEROWER, new Date());
        Outing outing4 = new Outing(UUID.randomUUID(), "Balliol W2", SubType.ROWER, new Date());
        Outing outing5 = new Outing(UUID.randomUUID(), "Trinity M2", SubType.STOKESIDEROWER, new Date());
        Outing outing6 = new Outing(UUID.randomUUID(), "Christ Church W2", SubType.SSTATUSCOX, new Date());
        Outing outing7 = new Outing(UUID.randomUUID(), "Worcester W1", SubType.COX, new Date());

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
