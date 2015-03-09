package com.gmaslowski.spring.integration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.annotation.IntegrationComponentScan;

@Configuration
@SpringBootApplication
@IntegrationComponentScan
public class IntegrationApp {

    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = SpringApplication.run(IntegrationApp.class, args);
        ctx.close();
    }

}
