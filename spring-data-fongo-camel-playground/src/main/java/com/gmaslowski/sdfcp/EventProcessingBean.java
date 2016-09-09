package com.gmaslowski.sdfcp;

import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class EventProcessingBean {

    public Event process(Event event) {
        event.setProcessed(new Date());
        return event;
    }
}
