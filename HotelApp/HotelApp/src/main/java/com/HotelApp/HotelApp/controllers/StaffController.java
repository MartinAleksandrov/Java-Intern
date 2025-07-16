package com.HotelApp.HotelApp.controllers;

import com.HotelApp.HotelApp.dtos.staffDtos.NewStaffDto;
import com.HotelApp.HotelApp.services.contracts.StaffService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/staff")
public class StaffController {

    private final StaffService staffService;

    @Autowired
    public StaffController(StaffService staffService) {
        this.staffService = staffService;
    }

    @PostMapping("/createStaff")
    public ResponseEntity<NewStaffDto> createStaff(@Valid @RequestBody NewStaffDto staffDto) {

        return new ResponseEntity<>(staffService.addStaff(staffDto),HttpStatus.CREATED);
    }
}