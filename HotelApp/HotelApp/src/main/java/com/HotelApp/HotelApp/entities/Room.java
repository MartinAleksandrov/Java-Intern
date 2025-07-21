package com.HotelApp.HotelApp.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Column;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.CascadeType;
import jakarta.persistence.JoinColumn;

import java.math.BigDecimal;
import java.util.Objects;
import java.util.UUID;


@Entity
@Table(name = "Room")
public class Room {

        @Id
        @GeneratedValue
        @Column(columnDefinition = "BINARY(16)", nullable = false,updatable = false)
        private UUID id;

        @Column(name = "name")
        private String name;

        @Column(name = "size")
        private Double size;

        @Column(name = "floor")
        private Integer floor;

        @Column(name = "price")
        private BigDecimal price;

        @Column(name = "is_booked")
        private Boolean isBooked;

        @ManyToOne(cascade = {CascadeType.DETACH,CascadeType.MERGE,
                              CascadeType.REFRESH, CascadeType.PERSIST})
        @JoinColumn(name = "hotel_id")
        private Hotel hotel;


        //Constructors
        public Room() {}

        public Room(String name, Double size, Integer floor, BigDecimal price, Boolean isBooked, Hotel hotel) {
            this.name = name;
            this.size = size;
            this.floor = floor;
            this.price = price;
            this.isBooked = isBooked;
            this.hotel = hotel;
        }



        //Get - Set
        public UUID getId() {
            return id;
        }

        public void setId(UUID id) {
        this.id = id;
        }

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

        public BigDecimal getPrice() {
            return price;
        }

        public void setPrice(BigDecimal price) {
            this.price = price;
        }

        public Boolean getIsBooked() {
            return isBooked;
        }

        public void setIsBooked(Boolean isBooked) {
            this.isBooked = isBooked;
        }

        public Hotel getHotel() {
            return hotel;
        }

        public void setHotel(Hotel hotel) {
            this.hotel = hotel;
        }

        public void setFloor(Integer floor) {
        this.floor = floor;
    }

        public void setBooked(Boolean booked) {
        isBooked = booked;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Room room = (Room) o;
        return Objects.equals(id, room.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}