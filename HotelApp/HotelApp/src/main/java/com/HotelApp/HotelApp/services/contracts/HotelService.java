package com.HotelApp.HotelApp.services.contracts;

import com.HotelApp.HotelApp.dtos.hotelDtos.HotelDto;
import com.HotelApp.HotelApp.dtos.roomDtos.AllRoomsDto;
import com.HotelApp.HotelApp.entities.Hotel;
import java.util.Set;


public interface HotelService {

    HotelDto addHotel(HotelDto hotelDto);
    Boolean removeHotel(Hotel hotel);
    Set<AllRoomsDto> getAllRooms(String hotelName);
    Hotel hotelExistByName(String hotelName);
}
