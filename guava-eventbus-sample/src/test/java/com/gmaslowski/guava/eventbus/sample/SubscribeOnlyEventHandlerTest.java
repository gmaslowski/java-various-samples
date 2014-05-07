package com.gmaslowski.guava.eventbus.sample;

import static java.util.concurrent.TimeUnit.SECONDS;
import org.junit.Test;
import com.gmaslowski.guava.eventbus.sample.handler.PersonWokeUpSubscribeOnly;

public class SubscribeOnlyEventHandlerTest extends AbstractEventBusTest {

    @Test
    public void testConcurrencyWithSameEvent() throws InterruptedException {
        // given
        eventHandler = new PersonWokeUpSubscribeOnly(eventBus, countDownLatch);
        prepareCallables(ONE_EVENT_TYPE);

        // when
        executorService.invokeAll(callables);
        countDownLatch.await(20, SECONDS);

        // then see output and analyze
    }

    @Test
    public void testConcurrencyWithDifferentEvents() throws InterruptedException {
        // given
        eventHandler = new PersonWokeUpSubscribeOnly(eventBus, countDownLatch);
        prepareCallables(DIFFERENT_EVENT_TYPES);

        // when
        executorService.invokeAll(callables);
        countDownLatch.await(20, SECONDS);

        // then see output and analyze
    }
}
