package com.HotelApp.HotelApp.facade.contracts;

import com.HotelApp.HotelApp.dtos.roomDtos.NewRoomDto;

public interface RoomFacade {
    NewRoomDto createRoom(NewRoomDto roomDto);
}
