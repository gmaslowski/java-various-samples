package com.gmaslowski.di.beans;

public class Service {

    private final Repository repository;

    public Service(Repository repository) {
        this.repository = repository;
    }

    public void call() {
        System.out.println("Service invocation.");
        repository.call();
    }

}
