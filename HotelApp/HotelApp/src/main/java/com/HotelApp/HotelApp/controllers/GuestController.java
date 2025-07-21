package com.HotelApp.HotelApp.controllers;

import com.HotelApp.HotelApp.dtos.guestDtos.NewGuestDto;
import com.HotelApp.HotelApp.services.contracts.GuestService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.UUID;

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

    @DeleteMapping("/removeGuest/{id}")
    public void deleteGuest(@PathVariable UUID id) {
        guestService.removeGuest(id);
    }
}
