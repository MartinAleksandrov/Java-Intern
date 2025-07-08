package Reflection;
//Reflection е способността на Java да разглежда класове, интерфейси, полета, методи и конструктори
// по време на изпълнение и да ги използва, дори ако не са били известни по време на компилация

public class Cat {

    private final String name;
    private final int age;
    private final String model;


    public Cat(String name, int age, String model) {
        this.name = name;
        this.age = age;
        this.model = model;
    }


    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public String getModel() {
        return model;
    }

    public void Meow(){
        System.out.println("Meow");
    }
    private void catSecrets(){
        System.out.println("I have very big cat secret");
    }
    private static void catSleep(){
        System.out.println("This is a sleep");
    }
}
