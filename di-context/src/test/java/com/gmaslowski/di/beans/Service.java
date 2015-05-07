package com.gmaslowski.di.beans;

public class Service {

    private final Repository repository;
    private final Component component;

    public Service(Repository repository, Component repositoryFucker) {
        this.repository = repository;
        this.component = repositoryFucker;
    }

    public void call() {
        System.out.println("Service invocation.");
        repository.call();
        component.callMeMaybe();
    }

}
