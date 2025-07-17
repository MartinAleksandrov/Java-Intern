package com.HotelApp.HotelApp.validators;

import com.HotelApp.HotelApp.customAnnotation.ValidData;
import com.HotelApp.HotelApp.dtos.bookingDtos.NewBookingDto;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.Date;

public class ValidDataValidator implements ConstraintValidator<ValidData, NewBookingDto> {

    @Override
    public boolean isValid(NewBookingDto newBookingDto, ConstraintValidatorContext constraintValidatorContext) {

        Date checkIn = newBookingDto.getCheckIn();
        Date checkOut = newBookingDto.getCheckOut();

        return checkIn.before(checkOut);
    }
}