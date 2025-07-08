package Annotations.DiAndReflection;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//Creating our custom annotation
@Target(ElementType.FIELD)//--> Анотацията може да се използва само върху полета
@Retention(RetentionPolicy.RUNTIME)//Accessible during runtime
public @interface Inject {
}
