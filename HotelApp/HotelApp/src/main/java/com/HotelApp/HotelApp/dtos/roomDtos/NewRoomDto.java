package com.HotelApp.HotelApp.dtos.roomDtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.hibernate.validator.constraints.Range;
import java.math.BigDecimal;

public class NewRoomDto {

    @NotBlank(message = "Name is required and must be max 50 symbols!")
    @Size(max = 50)
    private String name;

    @NotNull(message = "Size is required")
    private double size;

    @Range(min = 1, max = 20,message = "Floor must be in range 1-20")
    private int floor;

    @Positive
    private BigDecimal price;

    private Boolean isBooked;

    private String hotelName;


    /////////////////////
    public NewRoomDto() {}

    public NewRoomDto(String name, double size, int floor, BigDecimal price, boolean isBooked, String hotelName) {
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

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Boolean getIsBooked() {
        return isBooked;
    }

    public void setIsBooked(Boolean booked) {
        isBooked = booked;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }
}
