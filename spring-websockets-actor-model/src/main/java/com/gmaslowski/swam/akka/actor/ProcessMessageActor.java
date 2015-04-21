package com.gmaslowski.swam.akka.actor;

import com.gmaslowski.swam.akka.task.ProcessMessageTask;
import akka.actor.UntypedActor;
import akka.event.Logging;
import akka.event.LoggingAdapter;

public class ProcessMessageActor extends UntypedActor {

    private final LoggingAdapter log = Logging.getLogger(getContext().system(), this);

    @Override
    public void onReceive(Object message) throws Exception {
        ProcessMessageTask messageTask = (ProcessMessageTask) message;
        log.info("Processed message: {}", messageTask.getMessage().toString());
    }
}
