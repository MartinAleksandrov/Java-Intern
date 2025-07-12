package com.HotelApp.HotelApp.services.contracts;
import com.HotelApp.HotelApp.dtos.guestDtos.NewGuestDto;
import com.HotelApp.HotelApp.entities.Guest;

public interface GuestService {

    NewGuestDto createGuest(NewGuestDto guestDto);
}
