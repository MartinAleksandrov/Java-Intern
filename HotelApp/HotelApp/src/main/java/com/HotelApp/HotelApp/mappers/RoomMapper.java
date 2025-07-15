package com.HotelApp.HotelApp.mappers;

import com.HotelApp.HotelApp.dtos.roomDtos.NewRoomDto;
import com.HotelApp.HotelApp.entities.Room;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface RoomMapper {

    @Mapping(target = "hotelName", ignore = true)
    NewRoomDto toDto (Room room);

    //Полето в NewRoomDto е тип UUID, а полето в Room е hotel, взимаме само Id-то на Hotel
    //наираме го и ръчно мапваме стойноста
    @Mapping(target = "hotel", ignore = true)
    Room toEntity(NewRoomDto newRoomDto);
}
