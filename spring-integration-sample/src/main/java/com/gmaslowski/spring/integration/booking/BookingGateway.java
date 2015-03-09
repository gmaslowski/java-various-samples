package com.gmaslowski.spring.integration.booking;

import com.gmaslowski.spring.integration.dto.BookingRequest;
import com.gmaslowski.spring.integration.dto.BookingResult;
import org.springframework.integration.annotation.Gateway;

public interface BookingGateway {

    @Gateway(requestChannel = "bookingChannel")
    BookingResult placeBooking(BookingRequest bookingRequest);
}
