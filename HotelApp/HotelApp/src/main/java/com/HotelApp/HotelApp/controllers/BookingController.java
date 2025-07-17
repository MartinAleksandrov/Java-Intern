package com.HotelApp.HotelApp.controllers;

import com.HotelApp.HotelApp.dtos.bookingDtos.NewBookingDto;
import com.HotelApp.HotelApp.services.contracts.BookingService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/booking")
public class BookingController {

    private final BookingService bookingService;

    @Autowired
    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @PostMapping("/createBooking")
    public ResponseEntity<NewBookingDto> createBooking(@Valid @RequestBody NewBookingDto newBookingDto) {

        return new ResponseEntity<>(bookingService.addBooking(newBookingDto), HttpStatus.CREATED);
    }


}
