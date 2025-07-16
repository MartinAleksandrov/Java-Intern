package com.HotelApp.HotelApp.validators;

import com.HotelApp.HotelApp.customAnnotation.UniqueRoom;
import com.HotelApp.HotelApp.repositories.RoomRepository;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UniqueRoomNameValidator implements ConstraintValidator<UniqueRoom,String> {

    private final RoomRepository roomRepository;

    @Autowired
    public UniqueRoomNameValidator(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }


    @Override
    public boolean isValid(String roomName, ConstraintValidatorContext constraintValidatorContext) {

        if (roomName == null || roomName.isEmpty()) {
            return false;
        }

        return !roomRepository.existsByName(roomName);
    }
}