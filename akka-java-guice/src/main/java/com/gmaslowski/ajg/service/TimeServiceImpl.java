package com.gmaslowski.ajg.service;

import com.google.inject.Singleton;
import java.time.LocalDateTime;

@Singleton
public class TimeServiceImpl implements TimeService {

    @Override
    public String getCurrentTime() {
        return LocalDateTime.now().toString();
    }

}
