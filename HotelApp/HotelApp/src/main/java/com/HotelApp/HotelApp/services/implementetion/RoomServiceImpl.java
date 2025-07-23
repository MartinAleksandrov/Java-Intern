package com.HotelApp.HotelApp.services.implementetion;

import com.HotelApp.HotelApp.dtos.roomDtos.NewRoomDto;
import com.HotelApp.HotelApp.mappers.RoomMapper;
import com.HotelApp.HotelApp.repositories.HotelRepository;
import com.HotelApp.HotelApp.repositories.RoomRepository;
import com.HotelApp.HotelApp.services.contracts.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.UUID;

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
        if (hotel == null) {
            throw new RuntimeException("Hotel not found");
        }

        if (hotel.getRooms().stream()
                .anyMatch(room -> room.getName().equalsIgnoreCase(newRoomDto.getName()))) {
            throw new RuntimeException("Hotel already contains this room");
        }

        var newRoom = roomMapper.toEntity(newRoomDto);
        newRoom.setHotel(hotel);
        roomRepository.save(newRoom);
        return roomMapper.toDto(newRoom);
    }

    @Override
    public void removeRoom(UUID roomId) {
        roomRepository.deleteById(roomId);
        roomRepository.flush();

        if(roomRepository.existsById(roomId)) {
            throw new RuntimeException("Something went wrong, room is not deleted");
        }
    }

    @Override
    public NewRoomDto updateRoom(UUID roomId, NewRoomDto newRoomDto) {
        return null;
    }
}