package com.HotelApp.HotelApp.entities;

import com.HotelApp.HotelApp.enums.Gender;
import com.HotelApp.HotelApp.enums.Role;
import jakarta.persistence.*;

import java.util.UUID;

@Entity
public class Staff {
    @Id
    @GeneratedValue()
    @Column(columnDefinition = "BINARY(16)")
    private UUID id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Enumerated(EnumType.STRING)
    @Column(name = "gender")
    private Gender gender;

    @Column(name = "age")
    private short age;

    @Enumerated(EnumType.STRING)
    @Column(name = "role")
    private Role role;

    @ManyToOne(cascade = {CascadeType.DETACH,CascadeType.MERGE,
                          CascadeType.REFRESH, CascadeType.PERSIST})
    @JoinColumn(name = "hotel_id")
    private Hotel hotel;



    //Constructors
    public Staff() {}

    public Staff(String firstName, String lastName, Gender gender, short age, Role role, Hotel hotel) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.age = age;
        this.role = role;
        this.hotel = hotel;
    }



    //Get - Set

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public UUID getId() {
        return id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public short getAge() {
        return age;
    }

    public void setAge(short age) {
        this.age = age;
    }

    public Gender getGender() {
        return gender;
    }
}
