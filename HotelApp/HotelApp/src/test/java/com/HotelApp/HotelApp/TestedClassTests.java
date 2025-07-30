package com.HotelApp.HotelApp;

import com.HotelApp.HotelApp.Others.MockedClass;
import com.HotelApp.HotelApp.Others.TestedClass;
import org.assertj.core.api.SoftAssertions;
import org.assertj.core.util.Strings;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.doReturn;


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

        RuntimeException result = assertThrows(RuntimeException.class, () -> testedClass.clearEmails());

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


    //Soft Assertion allows to pass through all asserts
    @Test
    public void softAssertionsAllowsAllAssertionsToPass(){

        SoftAssertions softly = new SoftAssertions();

        String name = "Tosheto Petrov";
        int age = 21;
        double height = 1.2;

        //First assert fail, other are ignored
        //assertEquals("SOME NAME",name);
        //assertEquals(24,age);
        //assertEquals(1.2,height);

        softly.assertThat(name).isEqualTo("Tosheto Petrov");
        softly.assertThat(age).isEqualTo(21);
        softly.assertThat(height).isEqualTo(1.2);

        //This collect all asserts, without this method there will be no report
        softly.assertAll();
    }


    //Parameterized test
    @ParameterizedTest
    @ValueSource(strings = {"ivan@ab@v.bg","pesho@abv.bg","joro@gmail.com"})
    public void valueSourceShouldWorkCorrectly(String value){
        assertTrue(testedClass.isEmailCorrect(value));
    }


    //Calling dependency directly from object
    @Test
    public void callingDependencyFromServiceMustThrowException(){

        //when(testedClass.mockedClass.doSomething()).thenReturn("Something");
        //String result = testedClass.mockedClass.doSomething();

        doReturn("Something").when(mockedClass).doSomething();
        String result = mockedClass.doSomething();


        assertEquals("Something", result);
    }
}