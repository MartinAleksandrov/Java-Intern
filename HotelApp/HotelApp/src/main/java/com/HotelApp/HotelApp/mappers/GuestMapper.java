package com.HotelApp.HotelApp.mappers;

import com.HotelApp.HotelApp.dtos.guestDtos.NewGuestDto;
import com.HotelApp.HotelApp.entities.Guest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


@Mapper(componentModel = "spring")
public interface GuestMapper {

    //Изрично упоменаване кои полета да се мапнат едни с други, поради грешка в мапъра
    @Mapping(target = "gender", source = "gender")
    NewGuestDto toDto(Guest guest);

    @Mapping(target = "gender", source = "gender")
    Guest toEntity(NewGuestDto guest);

}