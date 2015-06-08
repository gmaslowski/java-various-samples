package com.gmaslowski.ajg.guice;

import com.gmaslowski.ajg.service.TimeService;
import com.gmaslowski.ajg.service.TimeServiceImpl;
import com.google.inject.AbstractModule;

public class GuiceInjector extends AbstractModule {

    @Override
    protected void configure() {
        bind(TimeService.class).to(TimeServiceImpl.class);
    }
}
