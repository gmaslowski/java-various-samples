package com.gmaslowski.guava.eventbus.sample.event;

import java.util.Date;

public abstract class AbstractWakingUpEvent {

    private long wakingUpTimestamp = new Date().getTime();

    public long wokeUpTime() {
        return wakingUpTimestamp;
    }
}
