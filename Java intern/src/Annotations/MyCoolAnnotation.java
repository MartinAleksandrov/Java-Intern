package Annotations;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//JVM не се интересува от всички анотации. Само тези, които имат @Retention(RetentionPolicy.RUNTIME)
//3 types annotations SOURCE, CLASS, RUNTIME

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface MyCoolAnnotation {

    String value() default "default";
}
