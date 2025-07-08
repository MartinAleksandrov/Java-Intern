package Design_Patterns.BuilderP;

public class BuilderExample {

    static Cat myCat = new Cat.Builder("Mittens",3)
            .setBreed("Siamese")
            .build();

    static Cat newCat = new Cat.Builder("Tomi",2)
                .setBreed("Siamese")
                .setColor("Brown")
                .setWeight(2)
                .setIsIndoor(true)
                .build();

    public static void printCat(){


        System.out.println("Cat: " + myCat.getName() + ", " +
                myCat.getBreed() + ", " +
                myCat.getAge() + " years old, " +
                myCat.getColor() + ", " +
                myCat.getWeight() + "kg, " +
                "Indoor: " + myCat.isIndoor());

        System.out.println("Cat: " + newCat.getName() + ", " +
                newCat.getBreed() + ", " +
                newCat.getAge() + " years old, ");
    }
}
