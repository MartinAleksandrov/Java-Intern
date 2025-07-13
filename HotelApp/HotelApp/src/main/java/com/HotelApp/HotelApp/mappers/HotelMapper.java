package com.HotelApp.HotelApp.mappers;

import com.HotelApp.HotelApp.dtos.hotelDtos.HotelDto;
import com.HotelApp.HotelApp.entities.Hotel;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface HotelMapper{

    //HotelGuestDto toDto(Hotel hotel);

    HotelDto toDto (Hotel hotel);
    Hotel toEntity(HotelDto hotelDto);
}
