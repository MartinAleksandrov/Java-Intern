package com.HotelApp.HotelApp.validators;

import com.HotelApp.HotelApp.customAnnotation.ValidData;
import com.HotelApp.HotelApp.dtos.bookingDtos.NewBookingDto;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import java.time.LocalDate;

public class ValidDataValidator implements ConstraintValidator<ValidData, NewBookingDto> {

    @Override
    public boolean isValid(NewBookingDto newBookingDto, ConstraintValidatorContext constraintValidatorContext) {

        LocalDate checkIn = newBookingDto.getCheckIn();
        LocalDate checkOut = newBookingDto.getCheckOut();

        return checkIn.isBefore(checkOut);
    }
}