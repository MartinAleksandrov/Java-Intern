package com.HotelApp.HotelApp.services.implementetion;

import com.HotelApp.HotelApp.entities.Hotel;
import com.HotelApp.HotelApp.mappers.HotelMapper;
import com.HotelApp.HotelApp.repositories.HotelRepository;
import com.HotelApp.HotelApp.services.contracts.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class HotelServiceImpl implements HotelService {

    private final HotelRepository hotelRepository;
    private final HotelMapper hotelMapper;

    @Autowired
    public HotelServiceImpl(HotelRepository hotelRepository, HotelMapper hotelMapper) {
        this.hotelRepository = hotelRepository;
        this.hotelMapper = hotelMapper;
    }

    @Override
    public Boolean addHotel(Hotel hotel) {
        return true;
    }

    @Override
    public Boolean removeHotel(Hotel hotel) {
        return true;
    }

//    @Override
//    public HotelGuestDto getGuestById(UUID id) {
//        return hotelRepository
//                .findById(id)
//                .map(hotelMapper::toDto)
//                .orElseThrow();
//    }
}
