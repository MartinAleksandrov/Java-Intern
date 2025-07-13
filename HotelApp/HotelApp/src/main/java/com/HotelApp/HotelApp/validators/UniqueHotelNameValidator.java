package com.HotelApp.HotelApp.validators;

import com.HotelApp.HotelApp.customAnnotation.UniqueHotelName;
import com.HotelApp.HotelApp.repositories.HotelRepository;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


//Създаваме валидатор ,като имплементираме интерфейс ConstraintValidator,
// който приема като аргументи името на анотацията, която ще изпорзва и от какъв тип е полето което ще се валидира.
@Component
public class UniqueHotelNameValidator implements ConstraintValidator<UniqueHotelName, String> {

    private final HotelRepository hotelRepository;

    @Autowired
    public UniqueHotelNameValidator(HotelRepository hotelRepository) {
        this.hotelRepository = hotelRepository;
    }

    //Идва от интерфейса
    @Override
    public boolean isValid(String hotelname, ConstraintValidatorContext constraintValidatorContext) {

        //Тези проверки оставяме на анотацията @NotBlank
        if (hotelname == null || hotelname.isEmpty()) {
            return true;
        }

        //Създаваме нов метод в hotelRepository
        return !hotelRepository.existsByName(hotelname.trim());
    }
}
