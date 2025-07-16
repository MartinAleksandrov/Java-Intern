package com.HotelApp.HotelApp.services.implementetion;

import com.HotelApp.HotelApp.dtos.roomDtos.NewRoomDto;
import com.HotelApp.HotelApp.mappers.RoomMapper;
import com.HotelApp.HotelApp.repositories.HotelRepository;
import com.HotelApp.HotelApp.repositories.RoomRepository;
import com.HotelApp.HotelApp.services.contracts.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoomServiceImpl implements RoomService {

    private final RoomRepository roomRepository;
    private final HotelRepository hotelRepository;
    private final RoomMapper roomMapper;

    @Autowired
    public RoomServiceImpl(RoomRepository roomRepository, RoomMapper roomMapper, HotelRepository hotelRepository) {
        this.roomRepository = roomRepository;
        this.hotelRepository = hotelRepository;
        this.roomMapper = roomMapper;
    }


    @Override
    public NewRoomDto createRoom(NewRoomDto newRoomDto) {

        var hotel = hotelRepository.findHotelByName(newRoomDto.getHotelName());

        if (hotel != null) {
            var newRoom = roomMapper.toEntity(newRoomDto);
            newRoom.setHotel(hotel);
            roomRepository.save(newRoom);
            hotel.addRoomToHotel(newRoom);
            return roomMapper.toDto(roomRepository.save(newRoom));

        }

        throw new RuntimeException("Hotel not found");
    }
}