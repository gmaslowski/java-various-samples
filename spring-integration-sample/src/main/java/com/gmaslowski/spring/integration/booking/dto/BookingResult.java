package com.gmaslowski.spring.integration.booking.dto;

public class BookingResult {

    private final String message;

    BookingResult(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return message;
    }
}
