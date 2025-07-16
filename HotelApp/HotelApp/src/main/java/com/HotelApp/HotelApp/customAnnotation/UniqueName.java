package com.HotelApp.HotelApp.customAnnotation;

import com.HotelApp.HotelApp.validators.UniqueNameValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Constraint(validatedBy = UniqueNameValidator.class)
public @interface UniqueName {
    public String message() default "Name already exists";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
