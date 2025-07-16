package com.HotelApp.HotelApp.entities;

import jakarta.persistence.*;

import java.util.UUID;
import java.util.Date;

@Entity
@Table(name = "Booking")
public class Booking {
    @Id
    @GeneratedValue()
    @Column(columnDefinition = "BINARY(16)")
    private UUID id;

    @Column(name = "check_in")
    private Date checkIn;

    @Column(name = "check_out")
    private Date checkOut;

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

    public Booking(Date checkIn, Date checkOut, Room room, Guest guest, Hotel hotel) {
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.room = room;
        this.guest = guest;
        this.hotel = hotel;
    }



    //Get - Set
    public Date getCheckIn() {
        return checkIn;
    }

    public Date getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(Date checkOut) {
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

    public UUID getId() {
        return id;
    }
}