package com.gmaslowski.sdfcp;

import org.apache.camel.spring.SpringRouteBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class EventProcessingRoute extends SpringRouteBuilder {

    public static final String PROCESS_EVENT_ROUTE = "processEvent";

    private final EventProcessingBean eventProcessingBean;

    @Autowired
    public EventProcessingRoute(EventProcessingBean eventProcessingBean) {
        this.eventProcessingBean = eventProcessingBean;
    }

    @Override
    public void configure() throws Exception {
        from("activemq:queue:event?jmsMessageType=Object")
                .routeId(PROCESS_EVENT_ROUTE)
                .bean(eventProcessingBean)
                .to("mongodb:events");
    }
}
