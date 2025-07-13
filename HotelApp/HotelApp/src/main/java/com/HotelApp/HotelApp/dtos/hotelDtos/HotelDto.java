package com.HotelApp.HotelApp.dtos.hotelDtos;

import com.HotelApp.HotelApp.customAnnotation.UniqueHotelName;
import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Range;

public class HotelDto {

    @NotBlank(message = "Hotel name is required")
    @UniqueHotelName // Custom Annotation
    private String name;

    @NotBlank(message = "Hotel must have owner")
    private String owner;

    @NotBlank(message = "Hotel must have city")
    private String city;

    @Range(min = 1, max = 5, message = "Hotel must have stars in range 1 to 5 ")
    private Short stars;


    //GET - SET METHODS

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
