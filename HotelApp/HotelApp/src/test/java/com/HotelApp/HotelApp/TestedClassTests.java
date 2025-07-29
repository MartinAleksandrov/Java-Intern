package com.HotelApp.HotelApp;

import com.HotelApp.HotelApp.Others.TestedClass;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class TestedClassTests {

    @Spy
    private TestedClass testedClass;

    @Test
    public void getMyNameShouldReturnCorrectName() {

        String name = "Tosheto Petrov";

        //Wrong pattern
        //when(testedClass.getMyName("Tosheto", "Petrov")).thenReturn(name);

        //Correct, First invoke doReturn
        doReturn(name).when(testedClass).getMyName("Tosheto", "Petrov");

        String result = testedClass.getMyName("Tosheto", "Petrov");

        assertEquals(name, result);
    }


    public 
}
