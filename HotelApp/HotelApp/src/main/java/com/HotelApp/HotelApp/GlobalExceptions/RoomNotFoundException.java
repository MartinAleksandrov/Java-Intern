package com.HotelApp.HotelApp.GlobalExceptions;

public class RoomNotFoundException extends RuntimeException{

    public RoomNotFoundException(Throwable cause) {
        super(cause);
    }

    public RoomNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public RoomNotFoundException(String message) {
        super(message);
    }
}
