package com.gmaslowski.guava.eventbus.sample.handler;

import static java.lang.Thread.currentThread;
import static java.lang.Thread.sleep;
import java.util.concurrent.CountDownLatch;
import com.gmaslowski.guava.eventbus.sample.event.JaneWokeUpEvent;
import com.gmaslowski.guava.eventbus.sample.event.JohnWokeUpEvent;
import com.google.common.eventbus.EventBus;

public abstract class AbstractWakingUpEventHandler {

    private CountDownLatch countDownLatch;

    public AbstractWakingUpEventHandler(EventBus eventBus, CountDownLatch countDownLatch) {
        eventBus.register(this);
        this.countDownLatch = countDownLatch;
    }

    public abstract void onJaneWokeUp(JaneWokeUpEvent event) throws InterruptedException;

    public abstract void onJohnWokeUp(JohnWokeUpEvent event) throws InterruptedException;

    protected void phase(int number) throws InterruptedException {
        System.out.println("Phase " + number + " of thread " + currentThread().getName());
        sleep(200); // for multi-threading
    }

    protected void endProcessing() {
        countDownLatch.countDown();
    }

}
