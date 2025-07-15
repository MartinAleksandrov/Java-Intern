package com.HotelApp.HotelApp.dtos.roomDtos;


import jakarta.validation.constraints.*;
import org.hibernate.validator.constraints.Range;
import org.hibernate.validator.constraints.UniqueElements;

import java.math.BigDecimal;
import java.util.UUID;


public class NewRoomDto {

    @NotBlank(message = "Name is required and must be max 50 symbols!")
    @Size(max = 50)
    private String name;

    @NotNull(message = "Size is required")
    private Double size;

    @Range(min = 1, max = 20,message = "Floor must be in range 1-20")
    private Integer floor;

    @Positive
    private BigDecimal price;

    private Boolean isBooked;

    @NotBlank
    private String hotelName;


    /////////////////////
    public NewRoomDto() {}

    public NewRoomDto(String name, Double size, Integer floor, BigDecimal price, Boolean isBooked, String hotelName) {
        this.name = name;
        this.size = size;
        this.floor = floor;
        this.price = price;
        this.isBooked = true;
        this.hotelName = hotelName;
    }



    /////////////////////
    //GET & SET Method
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getSize() {
        return size;
    }

    public void setSize(Double size) {
        this.size = size;
    }

    public Integer getFloor() {
        return floor;
    }

    public void setFloor(Integer floor) {
        this.floor = floor;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Boolean getBooked() {
        return isBooked;
    }

    public void setBooked(Boolean booked) {
        isBooked = booked;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }
}
