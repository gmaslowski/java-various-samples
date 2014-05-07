package com.gmaslowski.guava.eventbus.sample.handler;

import java.util.concurrent.CountDownLatch;
import com.gmaslowski.guava.eventbus.sample.event.JaneWokeUpEvent;
import com.gmaslowski.guava.eventbus.sample.event.JohnWokeUpEvent;
import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;

public class PersonWokeUpSubscribeOnly extends AbstractWakingUpEventHandler {

    public PersonWokeUpSubscribeOnly(EventBus eventBus, CountDownLatch countDownLatch) {
        super(eventBus, countDownLatch);
    }

    @Subscribe
    @Override
    public void onJaneWokeUp(JaneWokeUpEvent event) throws InterruptedException {
        phase(1);
        phase(2);
        phase(3);
        endProcessing();
    }

    @Subscribe
    @Override
    public void onJohnWokeUp(JohnWokeUpEvent event) throws InterruptedException {
        phase(1);
        phase(2);
        phase(3);
        phase(4);
        phase(5);
        endProcessing();
    }

}
