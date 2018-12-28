package com.nsa.behaviour.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by c1645238 on 21/11/2017.
 *
 * REF: CM6213 Commercial Applications with Java Slides
 *
 */
@Configuration
public class GeneralConfiguration extends WebMvcConfigurerAdapter{

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        // Defines the url to view the page that is being used to
        // Add and schedule activities.

        registry.addViewController("/index").setViewName("forward:/index.html");
        registry.addViewController("/activity").setViewName("forward:/newActivity.html");

        // shows the web form when the users inputs their current mood
        registry.addViewController("/mood").setViewName("forward:/mood.html");

        // Web configuration for viewing scheduled activities UI for specific users.
        registry.addViewController("/scheduled/**").setViewName("forward:/listActivities.html");

        // Web configuration for viewing activity reschedule page.
        registry.addViewController("/schedule/edit/**").setViewName("forward:/reschedule.html");

        // Web configuration for viewing action log of specific user.
        registry.addViewController("/actions/**").setViewName("forward:/recentActions.html");

        // Web configuration for viewing the new patient registration page.
        registry.addViewController("/patient/create/").setViewName("forward:/newPatient.html");

        // Web configuration for viewing action log of specific user.
        registry.addViewController("/patient/list/**").setViewName("forward:/listPatients.html");

        // Web configuration for logging in as a specific user.
        registry.addViewController("/login/**").setViewName("forward:/login.html");

        registry.addViewController("/linechart/**").setViewName("forward:/lineChart.html");

        registry.addViewController("/barchart/**").setViewName("forward:/barChart.html");

        registry.addViewController("/signup/**").setViewName("forward:/newPatient.html");

        registry.addViewController("/signup2/**").setViewName("forward:/signup.html");

        registry.addViewController("/test/**").setViewName("forward:/test.html");


    }


}