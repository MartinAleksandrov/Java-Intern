package com.HotelApp.HotelApp.services.contracts;
import com.HotelApp.HotelApp.dtos.guestDtos.NewGuestDto;
import java.util.UUID;

public interface GuestService {

    NewGuestDto createGuest(NewGuestDto guestDto);

    void removeGuest(UUID id);

}
