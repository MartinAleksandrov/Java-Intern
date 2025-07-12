package com.HotelApp.HotelApp.mappers;

import com.HotelApp.HotelApp.dtos.guestDtos.NewGuestDto;
import com.HotelApp.HotelApp.entities.Guest;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-07-12T21:43:30+0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 23.0.2 (Oracle Corporation)"
)
@Component
public class GuestMapperImpl implements GuestMapper {

    @Override
    public NewGuestDto toDto(Guest guest) {
        if ( guest == null ) {
            return null;
        }

        NewGuestDto newGuestDto = new NewGuestDto();

        newGuestDto.setGender( guest.getGender() );
        newGuestDto.setFirstName( guest.getFirstName() );
        newGuestDto.setLastName( guest.getLastName() );
        newGuestDto.setAge( guest.getAge() );
        newGuestDto.setPhone( guest.getPhone() );

        return newGuestDto;
    }

    @Override
    public Guest toEntity(NewGuestDto guest) {
        if ( guest == null ) {
            return null;
        }

        Guest guest1 = new Guest();

        guest1.setGender( guest.getGender() );
        guest1.setFirstName( guest.getFirstName() );
        guest1.setLastName( guest.getLastName() );
        guest1.setAge( guest.getAge() );
        guest1.setPhone( guest.getPhone() );

        return guest1;
    }
}
