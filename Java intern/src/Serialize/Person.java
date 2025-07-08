package Serialize;

import java.io.Serial;
import java.io.Serializable;

public class Person implements Serializable {

    //Проверява че версията на класа по време на сериализация е съвместима с версията по време на десериализация.
    //Java автоматично(Random)генерира един на база структурата на класа.
    // Затова е по добре да напишем свой Field с който лесно можем да променяме и следим версията на класа.
    @Serial
    private static final long serialVersionUID = 1L;

    String firstName;
    String lastName;
    String  city;
    String country;

    //Изключва полето от сериализацията автоматично,
    // можем да постигнем същия резултат и без transient просто като не записваме тази променлива,
    // редефинираш writeObject() и не включиш дадено поле там
    transient private final long id;

    int age;
    transient SomeClass someClass;




    public Person(String firstName, String lastName, long id, String city, String country, int age,SomeClass someClass) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = id;
        this.city = city;
        this.country = country;
        this.age = age;
        this.someClass = someClass;
    }



    public String getCountry() {
        return country;
    }

    public  SomeClass getSomeClass(){
        return  this.someClass;
    }
    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public long getId() {
        return id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
}