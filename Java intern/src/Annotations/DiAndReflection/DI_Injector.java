package Annotations.DiAndReflection;

import java.lang.reflect.Field;

public class DI_Injector {

    public static void injectDependencies(Object object) {

        Class<?> clazz = object.getClass();

        Field[] fields = clazz.getDeclaredFields();

        for (Field field : fields){

            try{
                field.setAccessible(true);

                // Вземаме типа на полето
                Class<?> fieldType = field.getType();

                // Създаваме нова инстанция на зависимостта
                var dependency = fieldType.getDeclaredConstructor().newInstance();

                //Инжектира създадения обект в целевото поле
                field.set(object, dependency);
                System.out.println("This is my cooolest reflection");

            }catch (Exception e){
                throw new RuntimeException("Грешка при инжектиране на: " + field.getName(), e);
            }
        }
    }
}
