package Reflection;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

//Този клас е с презентационна цел да покаже как работи Reflection
public class ReflectionStarter {

    public static void startReflectionExample () throws InvocationTargetException, IllegalAccessException {

        Cat cat = new Cat("Tomi",5,"Sphinx");
        System.out.println(cat.getName());

        Field[] catFields = cat.getClass().getDeclaredFields();//Takes all fields even private one
        Method[] catMethods = cat.getClass().getDeclaredMethods();//Takes all methods even private one

        for (Method m : catMethods) {
            m.setAccessible(true);// Makes methods accessible even if its private
            if (m.getName().equals("catSleep")) {// Search particular method with given name

                m.invoke(cat);//Извикваме метода на конкретния обект
            }
        }

        for (Field f : catFields) {
            f.setAccessible(true);// Makes fields accessible even if its private
            if (f.getName().equals("name")) // Search particular field with given name
            {
                f.set(cat,"Bob");//Подаваме като параметри конкретния обект и новата стойност
            }
            System.out.println(f.getName());
        }
        System.out.println(cat.getName());
    }
}
