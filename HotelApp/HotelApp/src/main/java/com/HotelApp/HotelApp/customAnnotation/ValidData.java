package com.HotelApp.HotelApp.customAnnotation;

import com.HotelApp.HotelApp.validators.ValidDataValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.annotation.Documented;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = ValidDataValidator.class )
public @interface ValidData {
    public String message() default "CheckIn must be before CheckOut";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}