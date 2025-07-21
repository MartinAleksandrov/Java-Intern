package com.HotelApp.HotelApp.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.CascadeType;

import java.util.Objects;
import java.util.UUID;
import java.util.Set;
import java.util.HashSet;

import jakarta.persistence.OneToMany;

@Entity
@Table(name = "Hotel")
public class Hotel {

    @Id
    @GeneratedValue()
    @Column(columnDefinition = "BINARY(16)", nullable = false,updatable = false)
    private UUID id;

    @Column(name = "name")
    private String name;

    @Column(name = "owner")
    private String owner;

    @Column(name = "city")
    private String city;

    @Column(name = "stars")
    private Short stars;

    @OneToMany(mappedBy = "hotel", cascade = CascadeType.ALL , orphanRemoval = true)
    private Set<Room> rooms;

    @OneToMany(mappedBy = "hotel", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Guest> guests;

    @OneToMany(mappedBy = "hotel", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Booking> bookings;

    @OneToMany(mappedBy = "hotel", cascade = CascadeType.ALL,orphanRemoval = true)
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

    public Set<Room> getRooms() {
        return rooms;
    }

    public void setRooms(Set<Room> rooms) {
        if(this.rooms != null && !this.rooms.isEmpty()) {
          this.rooms.addAll(rooms);
        }
        else {
            this.rooms = new HashSet<>();
        }
    }

    public Set<Guest> getGuests() {
        return guests;
    }

    public void setGuests(Set<Guest> guests) {
        if(this.guests != null && !this.guests.isEmpty()) {
            this.guests.addAll(guests);
        }
        else {
            this.guests = new HashSet<>();
        }
    }

    public Set<Staff> getStaffs() {
        return staffs;
    }

    public void setStaffs(Set<Staff> staffs) {
        if(this.staffs != null && !this.staffs.isEmpty()) {
            this.staffs.addAll(staffs);
        }
        else {
            this.staffs = new HashSet<>();
        }
    }

    public Set<Booking> getBookings() {
        return bookings;
    }

    public void setBookings(Set<Booking> bookings) {
        if(this.bookings != null && !this.bookings.isEmpty()) {
            this.bookings.addAll(bookings);
        }
        else {
            this.bookings = new HashSet<>();
        }
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public void addRoomToHotel(Room room)
    {
        this.rooms.add(room);
    }

    public void addStaffToHotel(Staff staff)
    {
        this.staffs.add(staff);
    }

    public void addBookingToHotel(Booking booking)
    {
        this.bookings.add(booking);
    }

    public void addGuestToHotel(Guest guest)
    {
        this.guests.add(guest);
    }


    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Hotel hotel = (Hotel) o;
        return Objects.equals(id, hotel.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}