package com.HotelApp.HotelApp.dtos.staffDtos;

import com.HotelApp.HotelApp.enums.Gender;
import com.HotelApp.HotelApp.enums.Role;

public record AllHotelStaffDto(String firstName,
                               String lastName,
                               Gender gender,
                               Short age,
                               Role role) {
}
