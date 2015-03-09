package com.gmaslowski.spring.integration.booking;

import dto.BookingRequest;
import dto.BookingResult;
import org.springframework.integration.annotation.Gateway;

public interface BookingGateway {

    @Gateway(requestChannel = "bookingChannel")
    BookingResult placeBooking(BookingRequest bookingRequest);
}
