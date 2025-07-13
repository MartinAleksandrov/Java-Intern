package com.HotelApp.HotelApp.customAnnotation;

import com.HotelApp.HotelApp.validators.UniquePhoneNumberValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Constraint(validatedBy = UniquePhoneNumberValidator.class)
public @interface UniquePhone {

    public String message() default "Phone number is already in use or is incorrect";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
