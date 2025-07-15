package com.HotelApp.HotelApp.entities;

import jakarta.persistence.*;

import java.util.UUID;


@Entity
@Table(name = "Room")
public class Room {

        @Id
        @GeneratedValue
        @Column(columnDefinition = "BINARY(16)")
        private UUID id;

        @Column(name = "name")
        private String name;

        @Column(name = "size")
        private Double size;

        @Column(name = "floor")
        private Integer floor;

        @Column(name = "price")
        private Double price;

        @Column(name = "is_booked")
        private Boolean isBooked;

        @ManyToOne
        @JoinColumn(name = "hotel_id")
        private Hotel hotel;


        //Constructors
        public Room() {}

        public Room(String name, Double size, Integer floor, Double price, Boolean isBooked, Hotel hotel) {
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

        public Double getPrice() {
            return price;
        }

        public void setPrice(Double price) {
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

}