package com.gmaslowski.ajg;

import com.gmaslowski.ajg.actor.Pong;
import com.gmaslowski.ajg.guice.GuiceActorProducer;
import com.gmaslowski.ajg.guice.GuiceInjector;
import com.google.inject.Guice;
import com.google.inject.Injector;
import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import scala.concurrent.duration.Duration;
import java.util.concurrent.TimeUnit;

public class Application {

    private static ActorSystem system = ActorSystem.create("akka");

    public static void main(String[] args) {

        Injector injector = Guice.createInjector(new GuiceInjector());
        ActorRef pongActor = system.actorOf(Props.create(GuiceActorProducer.class, injector, Pong.class));

        system.scheduler().schedule(
            Duration.create(0, TimeUnit.MILLISECONDS),
            Duration.create(5, TimeUnit.SECONDS),
            pongActor,
            "tick",
            system.dispatcher(),
            pongActor);
    }
}
