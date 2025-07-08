package Serialize;

public class SerializeStarter {

    public static void startSerializationExample() {
        Person myPerson =
                new Person("Ivan", "Petrov", 123456L, "Sofia", "Bulgaria", 30,new SomeClass());

        PersonSerializer.serializePersson(myPerson,"MySerializeFile.txt");

        Person dePerson = PersonSerializer.deSerializePersson("MySerializeFile.txt");

        if(dePerson != null) {
            System.out.println("Person name " + dePerson.getFirstName());
            System.out.println("Person id " + dePerson.getId());
            System.out.println("Person" + dePerson.getSomeClass());
        }

    }
}
