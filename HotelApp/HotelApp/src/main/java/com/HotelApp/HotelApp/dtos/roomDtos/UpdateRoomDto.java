package com.HotelApp.HotelApp.dtos.roomDtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import org.hibernate.validator.constraints.Range;
import java.math.BigDecimal;

public class UpdateRoomDto {

    private String roomId;

    @NotBlank(message = "Name is required and must be max 50 symbols!")
    @Size(max = 50)
    private String name;

    @NotNull(message = "Size is required")
    private double size;

    @Range(min = 1, max = 20,message = "Floor must be in range 1-20")
    private int floor;

    @Positive
    private BigDecimal price;


    //GET & SET
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }

    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }
}
