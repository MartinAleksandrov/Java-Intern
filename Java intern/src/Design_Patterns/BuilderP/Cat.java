package Design_Patterns.BuilderP;

public class Cat {
    private final String name;
    private final String breed;
    private final int age;
    private final  String color;
    private final double weight;
    private final boolean isIndoor;

    //Само Builder може да създава обекти
    private Cat(Builder builder) {
        this.name = builder.name;
        this.breed = builder.breed;
        this.age = builder.age;
        this.color = builder.color;
        this.weight = builder.weight;
        this.isIndoor = builder.isIndoor;
    }

    // Get методи (за достъп до стойностите)
    public String getName() {
        return name;
    }

    public String getBreed() {
        return breed;
    }

    public int getAge() {
        return age;
    }

    public String getColor() {
        return color;
    }

    public double getWeight() {
        return weight;
    }

    public boolean isIndoor() {
        return isIndoor;
    }


    // Вътрешен static клас — Builder
    public static class Builder {

        private final String name; //Тези полета за задължителни
        private String breed; //Optional
        private final int age; //Тези полета за задължителни
        private  String color; //Optional
        private double weight; //Optional
        private boolean isIndoor; //Optional

       public Builder(String name,int age) {

           if (name == null || name.isBlank()) {
               throw new IllegalArgumentException("Name is required.");
           }
           if (age < 0 || age > 100) {
               throw new IllegalArgumentException("Age cannot be negative or bigger than 100.");
           }
           this.name = name;
           this.age = age;
       }

        public Builder setBreed(String breed) {
            this.breed = breed;
            return this;
        }

        public Builder setColor(String color) {
            this.color = color;
            return this;
        }

        public Builder setWeight(double weight) {
            this.weight = weight;
            return this;
        }

        public Builder setIsIndoor(boolean isIndoor) {
            this.isIndoor = isIndoor;
            return this;
        }

        // Метод, който създава обект от тип Cat
        public Cat build() {
            return new Cat(this);
        }
    }
}
