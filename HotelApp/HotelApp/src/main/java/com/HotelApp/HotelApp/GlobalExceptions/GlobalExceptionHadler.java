package com.HotelApp.HotelApp.GlobalExceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHadler {

    @ExceptionHandler
    public ResponseEntity<RoomErrorResponse> handleExceptions(RoomNotFoundException ex){

        RoomErrorResponse response = new RoomErrorResponse();

        response.setMessage(ex.getMessage());
        response.setStatus(HttpStatus.NOT_FOUND.value());
        response.setTimeStamp(System.currentTimeMillis());

        return new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
    }
}
