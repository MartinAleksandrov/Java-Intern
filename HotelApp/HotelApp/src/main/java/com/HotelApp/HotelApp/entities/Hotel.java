package com.HotelApp.HotelApp.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.CascadeType;
import java.util.UUID;
import java.util.Set;
import java.util.HashSet;

import jakarta.persistence.OneToMany;

@Entity
@Table(name = "Hotel")
public class Hotel {

    @Id
    @GeneratedValue()
    @Column(columnDefinition = "UUID")
    private UUID id;

    @Column(name = "name")
    private String name;

    @Column(name = "owner")
    private String owner;

    @Column(name = "city")
    private String city;

    @Column(name = "stars")
    private Short stars;

    @OneToMany(mappedBy = "hotel", cascade = CascadeType.ALL)
    private Set<Room> rooms;

    @OneToMany(mappedBy = "hotel", cascade = CascadeType.ALL)
    private Set<Guest> guests;

    @OneToMany(mappedBy = "hotel", cascade = CascadeType.ALL)
    private Set<Booking> bookings;

    @OneToMany(mappedBy = "hotel", cascade = CascadeType.ALL)
    private Set<Staff> staffs;


    //Constructors
    public Hotel() {}

    public Hotel(String name, Short stars, String owner, String city) {
        this.name = name;
        this.stars = stars;
        this.owner = owner;
        this.city = city;
        rooms    = new HashSet<Room>();
        guests   = new HashSet<Guest>();
        bookings = new HashSet<Booking>();
        staffs   = new HashSet<Staff>();
    }



    //Get - Set
    public UUID getUuid() {
        return id;
    }

    public Short getStars() {
        return stars;
    }

    public void setStars(Short stars) {
        this.stars = stars;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}