package com.HotelApp.HotelApp.customAnnotation;

import com.HotelApp.HotelApp.validators.UniqueRoomNameValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;
import java.lang.annotation.Documented;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Documented
@Constraint(validatedBy = UniqueRoomNameValidator.class)
public @interface UniqueRoom {

    String message() default "Room name is already in use";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}