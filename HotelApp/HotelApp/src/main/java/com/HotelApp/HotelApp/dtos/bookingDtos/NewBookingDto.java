package com.HotelApp.HotelApp.dtos.bookingDtos;

import com.HotelApp.HotelApp.customAnnotation.ValidData;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;


@ValidData
public class NewBookingDto {

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @FutureOrPresent
    @NotNull
    private LocalDate checkIn;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @FutureOrPresent
    @NotNull
    private LocalDate checkOut;

    @NotBlank(message = "Room name is required")
    private String roomName;

    @NotBlank(message = "Guest name is required")
    private String guestFirstName;

    @NotBlank(message = "Guest name is required")
    private String guestLastName;


    @NotBlank(message = "Hotel name is required")
    private String hotelName;


    public NewBookingDto() {}

    public NewBookingDto(LocalDate checkIn, String hotelName, String guestLastName, String guestFirstName, String roomName, LocalDate checkOut) {
        this.checkIn = checkIn;
        this.hotelName = hotelName;
        this.guestLastName = guestLastName;
        this.guestFirstName = guestFirstName;
        this.roomName = roomName;
        this.checkOut = checkOut;
    }

    //GET & SET Methods


    public String getGuestFirstName() {
        return guestFirstName;
    }

    public void setGuestFirstName(String guestFirstName) {
        this.guestFirstName = guestFirstName;
    }

    public String getGuestLastName() {
        return guestLastName;
    }

    public void setGuestLastName(String guestLastName) {
        this.guestLastName = guestLastName;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }


    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public LocalDate getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(LocalDate checkOut) {
        this.checkOut = checkOut;
    }

    public LocalDate getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(LocalDate checkIn) {
        this.checkIn = checkIn;
    }
}