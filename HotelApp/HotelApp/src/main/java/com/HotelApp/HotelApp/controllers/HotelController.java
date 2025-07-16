package com.HotelApp.HotelApp.controllers;

import com.HotelApp.HotelApp.dtos.guestDtos.AllHotelGuestDto;
import com.HotelApp.HotelApp.dtos.hotelDtos.HotelDto;
import com.HotelApp.HotelApp.dtos.roomDtos.AllRoomsDto;
import com.HotelApp.HotelApp.dtos.staffDtos.AllHotelStaffDto;
import com.HotelApp.HotelApp.services.contracts.HotelService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;
import java.util.UUID;


@RestController
@RequestMapping("/hotel")
public class HotelController {

    private final HotelService hotelService;

    @Autowired
    public HotelController(HotelService hotelService) {
        this.hotelService = hotelService;
    }

    @PostMapping("/create")
    public ResponseEntity<HotelDto> createHotel(@Valid @RequestBody HotelDto dto) {

        var created = hotelService.addHotel(dto);

        return new ResponseEntity<>(created,HttpStatus.CREATED);
    }

    @GetMapping("/getAllHotelRooms/{hotelName}")
    public ResponseEntity<Set<AllRoomsDto>> getAllHotelRooms(@PathVariable String hotelName) {

        return new ResponseEntity<>(hotelService.getAllRooms(hotelName),HttpStatus.CREATED);
    }

    @GetMapping("/getAllHotelStaff/{hotelName}")
    public ResponseEntity<Set<AllHotelStaffDto>> getAllHotelStaff(@PathVariable String hotelName) {

        return new ResponseEntity<>(hotelService.getAllStaff(hotelName),HttpStatus.CREATED);
    }

    @GetMapping("/getAllHotelGuest/{hotelName}")
    public ResponseEntity<Set<AllHotelGuestDto>> getAllHotelGuest(@PathVariable String hotelName) {

        return new ResponseEntity<>(hotelService.getAllGuest(hotelName),HttpStatus.CREATED);
    }
}