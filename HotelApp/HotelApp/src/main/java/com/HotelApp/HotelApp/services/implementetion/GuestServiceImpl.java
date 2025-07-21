package com.HotelApp.HotelApp.services.implementetion;

import com.HotelApp.HotelApp.dtos.guestDtos.NewGuestDto;
import com.HotelApp.HotelApp.entities.Guest;
import com.HotelApp.HotelApp.mappers.GuestMapper;
import com.HotelApp.HotelApp.repositories.GuestRepository;
import com.HotelApp.HotelApp.services.contracts.GuestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.UUID;

@Service
public class GuestServiceImpl implements GuestService {

    private final GuestRepository guestRepository;
    private final GuestMapper guestMapper;

    @Autowired
    public GuestServiceImpl(GuestRepository guestRepository, GuestMapper guestMapper) {
        this.guestRepository = guestRepository;
        this.guestMapper = guestMapper;
    }

    @Override
    public NewGuestDto createGuest(NewGuestDto guestDto) {

        Guest guest = guestMapper.toEntity(guestDto);
        var newGuest = guestRepository.save(guest);
        return guestMapper.toDto(newGuest);

    }

    @Override
    public void removeGuest(UUID id) {

        guestRepository.deleteById(id);
        guestRepository.flush();

        if(guestRepository.existsById(id)){
            throw new RuntimeException("Guest with id " + id + " already exists");
        }
    }
}