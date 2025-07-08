package Serialize;

import java.io.*;

public class PersonSerializer {

    public static void serializePersson(Person person , String fileName) {
        try {

            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(fileName));
            objectOutputStream.writeObject(person);
            System.out.println("Serializing is successful :)");

        }
        catch (IOException e) {

            System.out.println("Serializing is NOT successful :(" + e.getMessage());
        }
    }

    public static Person deSerializePersson(String fileName){

        try{
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(fileName));
            Person deSerializePerson = (Person) objectInputStream.readObject();
            System.out.println("Deserializing is successful :)");
            return deSerializePerson;

        }catch (IOException | ClassNotFoundException e){
            System.out.println("Deserializing is NOT successful :(" + e.getMessage());
        }
            return null;
    }
}
