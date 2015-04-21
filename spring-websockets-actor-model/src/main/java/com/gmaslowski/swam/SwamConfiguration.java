package com.gmaslowski.swam;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("com.gmaslowski.swam")
@EnableAutoConfiguration
public class SwamConfiguration {

    public static void main(String[] args) {
        SpringApplication.run(SwamConfiguration.class, args);
    }

}
