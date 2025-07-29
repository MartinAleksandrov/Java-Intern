package com.HotelApp.HotelApp.Others;

import java.util.ArrayList;
import java.util.List;

public class TestedClass {

    private String name;
    private List<String> emails = new ArrayList<String>();


    public String getMyName(String FirstName, String LastName) {
        return name.toLowerCase() + FirstName.toLowerCase() + LastName.toLowerCase();
    }

    public void saveEmail() {

        var existingEmails = emails.contains("bob@gmail.com");

        if (!existingEmails) {
        emails.add("bob@gmail.com");
        }
        else {
            throw new RuntimeException("Email already exists");
        }

    }
}