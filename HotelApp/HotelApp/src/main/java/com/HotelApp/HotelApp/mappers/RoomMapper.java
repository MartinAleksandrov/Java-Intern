package com.HotelApp.HotelApp.mappers;

import com.HotelApp.HotelApp.dtos.roomDtos.NewRoomDto;
import com.HotelApp.HotelApp.dtos.roomDtos.RoomDto;
import com.HotelApp.HotelApp.dtos.roomDtos.UpdateRoomDto;
import com.HotelApp.HotelApp.entities.Room;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface RoomMapper {

    @Mapping(target = "hotelName", ignore = true)
    @Mapping(target = "isBooked" , source = "isBooked")
    NewRoomDto toDto (Room room);

    RoomDto toRoomDto (Room room);

    //Полето в NewRoomDto е тип UUID, а полето в Room е hotel, взимаме само Id-то на Hotel
    //наираме го и ръчно мапваме стойноста
    @Mapping(target = "hotel", ignore = true)
    @Mapping(target = "isBooked" , source = "isBooked")
    Room toEntity(NewRoomDto newRoomDto);

    UpdateRoomDto toUpdatedDto (Room room);


    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateEntityFromDto(UpdateRoomDto dto, @MappingTarget Room entity);
}