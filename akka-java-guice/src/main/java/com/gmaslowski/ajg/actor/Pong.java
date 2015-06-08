package com.gmaslowski.ajg.actor;

import com.gmaslowski.ajg.service.TimeServiceImpl;
import com.google.inject.Inject;
import akka.actor.UntypedActor;
import akka.event.Logging;
import akka.event.LoggingAdapter;

public class Pong extends UntypedActor {

    private LoggingAdapter log = Logging.getLogger(getContext().system(), this);

    @Inject
    private TimeServiceImpl timeService;

    @Override
    public void onReceive(Object message) throws Exception {
        log.info(timeService.getCurrentTime() + " - pong");
    }
}
