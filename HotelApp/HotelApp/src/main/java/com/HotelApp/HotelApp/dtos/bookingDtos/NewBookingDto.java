package com.HotelApp.HotelApp.dtos.bookingDtos;

import com.HotelApp.HotelApp.entities.Guest;
import com.HotelApp.HotelApp.entities.Hotel;
import com.HotelApp.HotelApp.entities.Room;
import jakarta.persistence.Column;

import java.util.Date;

public class NewBookingDto {

    @Column(name = "check_in")
    private Date checkIn;

    private Date checkOut;

    private Room room;

    private Guest guest;

    private Hotel hotel;
}
