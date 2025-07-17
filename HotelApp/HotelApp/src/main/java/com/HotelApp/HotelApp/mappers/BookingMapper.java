package com.HotelApp.HotelApp.mappers;

import com.HotelApp.HotelApp.dtos.bookingDtos.NewBookingDto;
import com.HotelApp.HotelApp.entities.Booking;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BookingMapper {

    NewBookingDto toDto(Booking booking);
    Booking toEntity(NewBookingDto bookingDto);
}