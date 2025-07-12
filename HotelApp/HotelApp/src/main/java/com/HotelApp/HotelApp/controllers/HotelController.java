package com.HotelApp.HotelApp.controllers;

import com.HotelApp.HotelApp.services.contracts.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/hotel")
public class HotelController {

    private final HotelService hotelService;

    @Autowired
    public HotelController(HotelService hotelService) {
        this.hotelService = hotelService;
    }

//    @DeleteMapping("/delete/{id}")
//    public String deleteHotel(@PathVariable UUID id) {
//        hotelRepository.deleteById(id);
//
//
//        return "Hotel deleted successfully";
//    }
//
//    @PostMapping("/create")
//    public Hotel createHotel(@RequestBody Hotel hotel) {
//
//        return hotelRepository.save(hotel);
//
//    }

}
