package com.HotelApp.HotelApp.controllers;

import com.HotelApp.HotelApp.dtos.roomDtos.NewRoomDto;
import com.HotelApp.HotelApp.dtos.roomDtos.UpdateRoomDto;
import com.HotelApp.HotelApp.services.contracts.RoomService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/room")
public class RoomController {

    private final RoomService roomService;

    @Autowired
    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    @PostMapping("/createRoom")
    public ResponseEntity<NewRoomDto> createRoom(@Valid @RequestBody NewRoomDto roomDto) {
        var room = roomService.createRoom(roomDto);

        return new ResponseEntity<>(roomDto, HttpStatus.CREATED);
    }

    @DeleteMapping("/removeRoom/{id}")
    public void deleteRoom(@PathVariable UUID id) {
        roomService.removeRoom(id);
    }

    @PutMapping("/updateRoom/{id}")
    public ResponseEntity<UpdateRoomDto> updateRoom(@PathVariable UUID id,@Valid  @RequestBody UpdateRoomDto roomDto) {

        return new ResponseEntity<>(roomService.updateRoom(id, roomDto), HttpStatus.OK);
    }
}