package com.HotelApp.HotelApp.dtos.guestDtos;

import com.HotelApp.HotelApp.enums.Gender;

public record AllHotelGuestDto(String firstName,
                               String lastName,
                               Gender gender,
                               Short age,
                               String phone) {
}
