package com.HotelApp.HotelApp.services.contracts;

import com.HotelApp.HotelApp.dtos.hotelDtos.HotelDto;
import com.HotelApp.HotelApp.entities.Hotel;


public interface HotelService {

    HotelDto addHotel(HotelDto hotelDto);
    Boolean removeHotel(Hotel hotel);
   // HotelGuestDto getGuestById(UUID id);
}
