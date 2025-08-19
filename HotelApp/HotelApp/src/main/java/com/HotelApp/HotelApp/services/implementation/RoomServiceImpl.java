package com.HotelApp.HotelApp.services.implementation;

import com.HotelApp.HotelApp.GlobalExceptions.RoomNotFoundException;
import com.HotelApp.HotelApp.dtos.roomDtos.NewRoomDto;
import com.HotelApp.HotelApp.dtos.roomDtos.RoomDto;
import com.HotelApp.HotelApp.dtos.roomDtos.UpdateRoomDto;
import com.HotelApp.HotelApp.entities.Room;
import com.HotelApp.HotelApp.mappers.RoomMapper;
import com.HotelApp.HotelApp.repositories.HotelRepository;
import com.HotelApp.HotelApp.repositories.RoomRepository;
import com.HotelApp.HotelApp.services.contracts.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.NoSuchElementException;
import java.util.Optional;
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
    public RoomDto getRoomById(UUID id) {
        Optional<Room> room = roomRepository.findById(id);

        if (room.isEmpty()) {
            throw new RoomNotFoundException("Room not found - " + id);
        }

        return roomMapper.toRoomDto(room.get());
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
    public UpdateRoomDto updateRoom(UUID roomId, UpdateRoomDto newRoomDto) {

        var room = roomRepository.findById(roomId)
                .orElseThrow(() -> new NoSuchElementException("Room not found"));

        roomMapper.updateEntityFromDto(newRoomDto, room);
        roomRepository.save(room);


        return roomMapper.toUpdatedDto(room);
    }
}