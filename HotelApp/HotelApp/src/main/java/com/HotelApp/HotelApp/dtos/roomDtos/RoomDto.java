package com.HotelApp.HotelApp.dtos.roomDtos;

import java.math.BigDecimal;

public record RoomDto(String name,
                      Double size,
                      Integer floor,
                      BigDecimal price,
                      Boolean isBooked) {
}