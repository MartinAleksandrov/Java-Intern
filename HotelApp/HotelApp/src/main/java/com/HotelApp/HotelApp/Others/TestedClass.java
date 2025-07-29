package com.HotelApp.HotelApp.Others;


import java.util.ArrayList;
import java.util.List;

public class TestedClass {

    private String name;
    private List<String> emails = new ArrayList<String>();
    public MockedClass mockedClass = new MockedClass();

    public String getMyName(String FirstName, String LastName) {
        return name.toLowerCase() + FirstName.toLowerCase() + LastName.toLowerCase();
    }

    public void saveEmail(String email) {

        var existingEmails = emails.contains(email);


        if (!existingEmails) {
        emails.add(email);
        }
        else {
            throw new RuntimeException("Email already exists");
        }
    }

    public String clearEmails() {

        if (emails.isEmpty()) {
            throw new RuntimeException("No emails have been saved");
        }
        emails.clear();
        return "Successfully saved emails";
    }

    public String usedMockedClass() {
        String res = mockedClass.doSomething();

        return res;
    }

    public boolean isEmailCorrect(String email) {

        return email.matches("^[^@]+@[^@]+\\.[^@]+$");
    }
}