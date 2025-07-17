package com.HotelApp.HotelApp.services.contracts;

import com.HotelApp.HotelApp.dtos.bookingDtos.NewBookingDto;

public interface BookingService {

    NewBookingDto addBooking(NewBookingDto newBookingDto);
}
