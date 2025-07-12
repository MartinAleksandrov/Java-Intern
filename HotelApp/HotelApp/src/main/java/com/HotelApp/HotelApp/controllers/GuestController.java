package com.HotelApp.HotelApp.controllers;

import com.HotelApp.HotelApp.dtos.guestDtos.NewGuestDto;
import com.HotelApp.HotelApp.entities.Guest;
import com.HotelApp.HotelApp.services.contracts.GuestService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/guest")
public class GuestController {

    private final GuestService guestService;

    @Autowired
    public GuestController(GuestService guestService) {
        this.guestService = guestService;
    }

    @PostMapping("/createGuest")
    public ResponseEntity<NewGuestDto> createGuest(@Valid @RequestBody NewGuestDto guestDto) {
        return new ResponseEntity<>(guestService.createGuest(guestDto), HttpStatus.CREATED);
    }
}
