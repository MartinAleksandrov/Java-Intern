package com.HotelApp.HotelApp.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.UUID;
import java.util.Date;

@Entity
@Table(name = "Booking")
public class Booking {
    @Id
    @GeneratedValue()
    @Column(columnDefinition = "BINARY(16)", nullable = false,updatable = false)
    private UUID id;

    @Column(name = "check_in")
    private LocalDate checkIn;

    @Column(name = "check_out")
    private LocalDate checkOut;

    @OneToOne(cascade = {CascadeType.DETACH,CascadeType.MERGE,
                         CascadeType.REFRESH, CascadeType.PERSIST})
    @JoinColumn(name = "room_id")
    private Room room;

    @OneToOne(cascade = {CascadeType.DETACH,CascadeType.MERGE,
                         CascadeType.REFRESH, CascadeType.PERSIST})
    @JoinColumn(name = "guest_id")
    private Guest guest;

    @ManyToOne(cascade = {CascadeType.DETACH,CascadeType.MERGE,
                          CascadeType.REFRESH, CascadeType.PERSIST})
    @JoinColumn(name = "hotel_id")
    private Hotel hotel;



    //Constructors
    public Booking() {}

    public Booking(LocalDate checkIn, LocalDate checkOut, Room room, Guest guest, Hotel hotel) {
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.room = room;
        this.guest = guest;
        this.hotel = hotel;
    }



    //Get - Set
    public LocalDate getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(LocalDate checkIn) {
        this.checkIn = checkIn;
    }

    public LocalDate getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(LocalDate checkOut) {
        this.checkOut = checkOut;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public Guest getGuest() {
        return guest;
    }

    public void setGuest(Guest guest) {
        this.guest = guest;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

}