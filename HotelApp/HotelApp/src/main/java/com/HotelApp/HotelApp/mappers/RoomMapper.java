package com.HotelApp.HotelApp.mappers;

import com.HotelApp.HotelApp.dtos.roomDtos.AllRoomsDto;
import com.HotelApp.HotelApp.dtos.roomDtos.NewRoomDto;
import com.HotelApp.HotelApp.entities.Room;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.Set;

@Mapper(componentModel = "spring")
public interface RoomMapper {

    @Mapping(target = "hotelName", ignore = true)
    @Mapping(target = "isBooked" , source = "isBooked")
    NewRoomDto toDto (Room room);

    //Полето в NewRoomDto е тип UUID, а полето в Room е hotel, взимаме само Id-то на Hotel
    //наираме го и ръчно мапваме стойноста
    @Mapping(target = "hotel", ignore = true)
    @Mapping(target = "isBooked" , source = "isBooked")
    Room toEntity(NewRoomDto newRoomDto);

}
