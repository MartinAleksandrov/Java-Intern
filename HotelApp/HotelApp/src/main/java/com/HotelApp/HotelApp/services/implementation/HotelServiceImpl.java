package com.HotelApp.HotelApp.services.implementation;

import com.HotelApp.HotelApp.dtos.guestDtos.AllHotelGuestDto;
import com.HotelApp.HotelApp.dtos.hotelDtos.HotelDto;
import com.HotelApp.HotelApp.dtos.roomDtos.AllRoomsDto;
import com.HotelApp.HotelApp.dtos.staffDtos.AllHotelStaffDto;
import com.HotelApp.HotelApp.entities.Hotel;
import com.HotelApp.HotelApp.mappers.HotelMapper;
import com.HotelApp.HotelApp.repositories.HotelRepository;
import com.HotelApp.HotelApp.services.contracts.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Set;


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
    public HotelDto addHotel(HotelDto hotelDto) {
        Hotel entity = hotelMapper.toEntity(hotelDto);
        var saved = hotelRepository.save(entity);
        return hotelMapper.toDto(saved);
    }

    @Override
    public Boolean removeHotel(Hotel hotel) {
        return true;
    }
 // Just comment
    @Override
    public Set<AllRoomsDto> getAllRooms(String hotelName) {

        var hotel = hotelExistByName(hotelName);

        if (hotel != null) {
          return hotelMapper.toDtoSet(hotel.getRooms());
        }
         throw new RuntimeException("Hotel not found");

    }

    @Override
    public Set<AllHotelStaffDto> getAllStaff(String hotelName) {
        var hotel = hotelRepository.findHotelByName(hotelName);

        if (hotel == null) {
            throw new RuntimeException("Hotel not found");
        }

        return hotelMapper.toStaffDtoSet(hotel.getStaffs());

    }

    @Override
    public Set<AllHotelGuestDto> getAllGuest(String hotelName) {
        var hotel = hotelRepository.findHotelByName(hotelName);
        if (hotel == null) {
            throw new RuntimeException("Hotel not found");
        }

        return hotelMapper.toGuestDtoSet(hotel.getGuests());

    }

    @Override
    public Hotel hotelExistByName(String hotelName) {

        return hotelRepository.findHotelByName(hotelName);
    }
}