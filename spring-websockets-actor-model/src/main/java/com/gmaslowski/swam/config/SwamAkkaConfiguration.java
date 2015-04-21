package com.gmaslowski.swam.config;

import com.gmaslowski.swam.akka.actor.ProcessMessageActor;
import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;

@Configuration
@Lazy
@ComponentScan(basePackages = {
        "com.gmaslowski.swam.akka"
})
public class SwamAkkaConfiguration {

    public static final String MESSAGE_TASK_PROCESSING = "MessageTaskProcessing";

    @Bean
    public ActorSystem actorSystem() {
        return ActorSystem.create(MESSAGE_TASK_PROCESSING, akkaConfiguration());
    }

    @Bean
    public Config akkaConfiguration() {
        return ConfigFactory.load();
    }

    @Bean
    public ActorRef processMessageActor() {
        return actorSystem().actorOf(Props.create(ProcessMessageActor.class), "processMessageActor");

    }
}
