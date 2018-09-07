package com.andreitop.newco.error;

public class TripNotFoundException extends Exception {
    public TripNotFoundException(){
        super();
    }

    public TripNotFoundException(String message){
        super(message);
    }

    public String getMessage(){
        String message = "Trip is not found";
        return message;
    }
}
