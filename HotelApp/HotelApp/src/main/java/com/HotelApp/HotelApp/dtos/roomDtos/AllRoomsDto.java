package com.HotelApp.HotelApp.dtos.roomDtos;

import java.math.BigDecimal;

public record AllRoomsDto(String name,
                          Double size,
                          Integer floor,
                          BigDecimal price,
                          Boolean isBooked) {
}