package com.HotelApp.HotelApp.facade;

import com.HotelApp.HotelApp.dtos.roomDtos.NewRoomDto;
import com.HotelApp.HotelApp.facade.contracts.RoomFacade;
import com.HotelApp.HotelApp.services.contracts.RoomService;
import org.springframework.stereotype.Component;

@Component
public class RoomFacadeImpl implements RoomFacade {

    private final RoomService roomService;

    public RoomFacadeImpl(RoomService roomService) {
        this.roomService = roomService;
    }

    @Override
    public NewRoomDto createRoom(NewRoomDto roomDto) {
        // Here you can orchestrate multiple services if needed
        return roomService.createRoom(roomDto);
    }
}
