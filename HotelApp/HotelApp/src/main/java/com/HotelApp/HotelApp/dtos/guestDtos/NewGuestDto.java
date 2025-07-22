package com.HotelApp.HotelApp.dtos.guestDtos;

import com.HotelApp.HotelApp.customAnnotation.UniquePhone;
import com.HotelApp.HotelApp.enums.Gender;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.hibernate.validator.constraints.Range;

public class NewGuestDto {

    @NotBlank(message = "First name is required")
    @Size(min = 3, max = 30 , message = "First name must be at most 30 characters" )
    private String firstName;

    @NotBlank(message = "Last name is required")
    @Size(min = 3, max = 30, message = "Last name must be at most 30 characters")
    private String lastName;

    @NotNull(message = "Age is required")
    @Range(min = 0, max = 111)
    private short age;

    @NotNull(message = "Gender is required")
    private Gender gender;

    //Custom annotation that combine all these annotations(NotBlank,Size,Min,Max) and check regex.
    @UniquePhone
    private String phone;


    //GET - SET METHODS

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

    public Short getAge() {
        return age;
    }

    public void setAge(Short age) {
        this.age = age;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
