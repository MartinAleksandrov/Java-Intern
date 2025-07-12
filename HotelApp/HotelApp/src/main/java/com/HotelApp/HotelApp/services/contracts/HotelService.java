package com.HotelApp.HotelApp.services.contracts;

import com.HotelApp.HotelApp.entities.Hotel;


public interface HotelService {

    Boolean addHotel(Hotel hotel);
    Boolean removeHotel(Hotel hotel);
   // HotelGuestDto getGuestById(UUID id);
}
