package com.HotelApp.HotelApp.controllers;

import com.HotelApp.HotelApp.GlobalExceptions.RoomErrorResponse;
import com.HotelApp.HotelApp.GlobalExceptions.RoomNotFoundException;
import com.HotelApp.HotelApp.dtos.roomDtos.NewRoomDto;
import com.HotelApp.HotelApp.dtos.roomDtos.RoomDto;
import com.HotelApp.HotelApp.dtos.roomDtos.UpdateRoomDto;
import com.HotelApp.HotelApp.services.contracts.RoomService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.UUID;

@RestController
@RequestMapping("/room")
public class RoomController {

    private final RoomService roomService;

    @Autowired
    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }


    @GetMapping("/{id}")
    public ResponseEntity<RoomDto> getRoom(@PathVariable UUID id) {
        RoomDto dto =  roomService.getRoomById(id);

        return new ResponseEntity<>(dto,HttpStatus.OK);
    }

    @ExceptionHandler
    public ResponseEntity<RoomErrorResponse> handleExceptions(RoomNotFoundException ex){

        RoomErrorResponse response = new RoomErrorResponse();

        response.setMessage(ex.getMessage());
        response.setStatus(HttpStatus.NOT_FOUND.value());
        response.setTimeStamp(System.currentTimeMillis());

        return new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
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