package com.HotelApp.HotelApp.validators;

import com.HotelApp.HotelApp.customAnnotation.UniqueName;
import com.HotelApp.HotelApp.dtos.staffDtos.NewStaffDto;
import com.HotelApp.HotelApp.repositories.StaffRepository;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UniqueNameValidator implements ConstraintValidator<UniqueName, NewStaffDto> {

    private final StaffRepository staffRepository;

    @Autowired
    public UniqueNameValidator(StaffRepository staffRepository) {
        this.staffRepository = staffRepository;
    }

    @Override
    public boolean isValid(NewStaffDto staffDto, ConstraintValidatorContext constraintValidatorContext) {
        //Проверяваме за уникалност по първо име и фамилия
        return !staffRepository.existsByFirstNameAndLastName(staffDto.getFirstName(), staffDto.getLastName());
    }
}
