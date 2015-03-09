package com.gmaslowski.spring.integration.dto;

public class Address {

    private final String city;

    public Address(String city) {
        this.city = city;
    }

    public String getCity() {
        return city;
    }

    @Override
    public String toString() {
        return city;
    }
}
