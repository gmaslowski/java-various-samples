package com.gmaslowski.guava.eventbus.sample;

import static com.google.common.collect.Lists.newArrayList;
import static java.util.concurrent.Executors.newFixedThreadPool;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import com.gmaslowski.guava.eventbus.sample.event.AbstractWakingUpEvent;
import com.gmaslowski.guava.eventbus.sample.event.JaneWokeUpEvent;
import com.gmaslowski.guava.eventbus.sample.event.JohnWokeUpEvent;
import com.gmaslowski.guava.eventbus.sample.handler.AbstractWakingUpEventHandler;
import com.google.common.eventbus.EventBus;

public abstract class AbstractEventBusTest {

    protected static final int CALLABLE_COUNT = 10;
    protected static final Boolean ONE_EVENT_TYPE = true;
    protected static final Boolean DIFFERENT_EVENT_TYPES = false;

    protected EventBus eventBus = new EventBus();
    protected AbstractWakingUpEventHandler eventHandler;

    protected List<Callable<Void>> callables = newArrayList();
    protected CountDownLatch countDownLatch = new CountDownLatch(CALLABLE_COUNT);
    protected ExecutorService executorService = newFixedThreadPool(CALLABLE_COUNT / 2);

    protected void prepareCallables(final Boolean eventType) {
        for (int i = 0; i < CALLABLE_COUNT; i++) {
            callables.add(new Callable<Void>() {

                @Override
                public Void call() throws Exception {
                    eventBus.post(prepareEvent(eventType));
                    return null;
                }
            });
        }
    }

    private AbstractWakingUpEvent prepareEvent(Boolean events) {
        return events.equals(ONE_EVENT_TYPE) ? new JaneWokeUpEvent() : randomEvent();
    }

    private AbstractWakingUpEvent randomEvent() {
        if (new Random().nextBoolean() == true) {
            return new JohnWokeUpEvent();
        }
        return new JaneWokeUpEvent();
    }

}
