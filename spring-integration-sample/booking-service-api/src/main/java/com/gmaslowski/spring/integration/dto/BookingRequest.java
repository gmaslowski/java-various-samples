package com.gmaslowski.spring.integration.dto;

public class BookingRequest {

    private final Address address;

    public BookingRequest(Address address) {
        this.address = address;
    }

    public Address getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return "BookingRequest for: " + address.getCity();
    }
}
