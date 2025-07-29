package com.HotelApp.HotelApp;

import com.HotelApp.HotelApp.Others.MockedClass;
import com.HotelApp.HotelApp.Others.TestedClass;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class TestedClassTests {

    @Spy
    private TestedClass testedClass;

    @InjectMocks
    private TestedClass tc;

    @Mock
    private MockedClass mockedClass;


    //Do Return example
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

    //Do throw example
    @Test
    public void clearEmailsShouldThrowException(){

        //We want method to throw exception
        doThrow(new RuntimeException("No emails have been saved"))
                .when(testedClass).clearEmails();

        RuntimeException result = assertThrows(RuntimeException.class, () -> {
            testedClass.clearEmails();
        });

        assertEquals("No emails have been saved", result.getMessage());
    }


    //Does InjectMocks find dependencies with field injection
    /*InjectMocks inject dependencies by type, if 2 fields have same type
    InjectMocks will throw exception */
    @Test
    public void correctMocking(){

        when(tc.usedMockedClass()).thenReturn("success");

        var result = tc.usedMockedClass();
        assertEquals("success", result);
    }
}
