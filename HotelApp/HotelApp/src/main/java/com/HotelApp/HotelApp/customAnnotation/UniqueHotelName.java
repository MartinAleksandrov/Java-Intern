package com.HotelApp.HotelApp.customAnnotation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.lang.annotation.RetentionPolicy;

//Анотация която проверява уникалноста на името на даден хотел
@Documented
@Constraint(validatedBy = com.HotelApp.HotelApp.validators.UniqueHotelNameValidator.class)//Кой клас валидира анотацията
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface UniqueHotelName {
    String message() default "Hotel with this name already exists";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}