package com.HotelApp.HotelApp.dtos.staffDtos;

import com.HotelApp.HotelApp.customAnnotation.UniqueName;
import com.HotelApp.HotelApp.enums.Gender;
import com.HotelApp.HotelApp.enums.Role;
import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Range;

@UniqueName
public class NewStaffDto {

    @NotBlank(message = "First name is required")
    private String firstName;

    @NotBlank(message = "Last name is required")
    private String lastName;

    private Gender gender;

    @Range(min = 18, max = 65, message = "Age must be between 18 and 65")
    private Short age;

    private Role role;

    @NotBlank(message = "Hotel name is required")
    private String hotelName;



    public NewStaffDto() {}

    public NewStaffDto(String firstName, String lastName, Gender gender, short age, Role role, String hotelName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.age = age;
        this.role = role;
        this.hotelName = hotelName;
    }


    //GET & SET Methods

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public short getAge() {
        return age;
    }

    public void setAge(short age) {
        this.age = age;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }
}
