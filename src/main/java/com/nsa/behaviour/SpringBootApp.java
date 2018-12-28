package com.nsa.behaviour;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.web.servlet.ErrorPage;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;

/**
 * Created by c1645238 on 17/11/2017.
 */

@SpringBootApplication
public class SpringBootApp {

    @Bean
    public EmbeddedServletContainerCustomizer containerCustomizer(){
        return (container -> {
            ErrorPage custom404Page = new ErrorPage(HttpStatus.NOT_FOUND,"/404");
            container.addErrorPages(custom404Page);
        });
    }


    public static void main(String args[]) {
        SpringApplication.run(SpringBootApp.class, args);
    }

}
