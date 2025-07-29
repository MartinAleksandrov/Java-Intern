package com.HotelApp.HotelApp.services.contracts;

import com.HotelApp.HotelApp.dtos.roomDtos.NewRoomDto;
import com.HotelApp.HotelApp.dtos.roomDtos.RoomDto;
import com.HotelApp.HotelApp.dtos.roomDtos.UpdateRoomDto;
import java.util.UUID;

public interface RoomService {

    RoomDto getRoomById(UUID id);

    NewRoomDto createRoom(NewRoomDto newRoomDto);

    void removeRoom(UUID roomId);

    UpdateRoomDto updateRoom(UUID roomId, UpdateRoomDto newRoomDto);
}