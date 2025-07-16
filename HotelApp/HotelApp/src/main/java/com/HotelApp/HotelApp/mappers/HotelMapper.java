package com.HotelApp.HotelApp.mappers;

import com.HotelApp.HotelApp.dtos.hotelDtos.HotelDto;
import com.HotelApp.HotelApp.dtos.roomDtos.AllRoomsDto;
import com.HotelApp.HotelApp.dtos.staffDtos.AllHotelStaffDto;
import com.HotelApp.HotelApp.entities.Hotel;
import com.HotelApp.HotelApp.entities.Room;
import com.HotelApp.HotelApp.entities.Staff;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.Set;

@Mapper(componentModel = "spring")
public interface HotelMapper{

    HotelDto toDto (Hotel hotel);
    Hotel toEntity(HotelDto hotelDto);

    Set<AllRoomsDto> toDtoSet (Set<Room> rooms);
    Set<AllHotelStaffDto> toStaffDtoSet(Set<Staff> staffCollection);


}
