package com.HotelApp.HotelApp.validators;

import com.HotelApp.HotelApp.customAnnotation.UniquePhone;
import com.HotelApp.HotelApp.repositories.GuestRepository;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UniquePhoneNumberValidator implements ConstraintValidator<UniquePhone,String> {

    private final GuestRepository guestRepository;

    @Autowired
    public UniquePhoneNumberValidator(final GuestRepository guestRepository) {
        this.guestRepository = guestRepository;
    }

    @Override
    public boolean isValid(String phoneNumber, ConstraintValidatorContext constraintValidatorContext) {

        if (phoneNumber == null ||
                phoneNumber.isBlank() ||
                phoneNumber.length() > 30 ||
                phoneNumber.length() < 3 ||
                !phoneNumber.matches("^\\d{3,30}$")) {
            return false;
        }

        return !guestRepository.phoneExists(phoneNumber);
    }
}