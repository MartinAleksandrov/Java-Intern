package com.HotelApp.HotelApp.services.contracts;

import com.HotelApp.HotelApp.dtos.roomDtos.NewRoomDto;

public interface RoomService {

    NewRoomDto createRoom(NewRoomDto newRoomDto);
}
