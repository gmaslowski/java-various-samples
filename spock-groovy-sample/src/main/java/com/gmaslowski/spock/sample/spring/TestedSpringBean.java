package com.gmaslowski.spock.sample.spring;

import org.springframework.stereotype.Component;

@Component
public class TestedSpringBean implements SpringBean {

    @Override
    public String doSomeWork() {
        return "did the work";
    }
}
