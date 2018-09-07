package com.andreitop.newco.error;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class TripNotFoundExceptionHandler {

    @ExceptionHandler(TripNotFoundException.class)
    public ResponseEntity<DtoApiError> exceptionTripNotFoundHandler(Exception ex){
        DtoApiError error = new DtoApiError();
        error.setErrorCode(HttpStatus.NOT_FOUND.value());
        error.setErrorMessage(ex.getMessage());
        return new ResponseEntity<DtoApiError>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler({Exception.class})
    public ResponseEntity<DtoApiError> exceptionHandler(Exception ex){
        DtoApiError error = new DtoApiError();
        error.setErrorCode(HttpStatus.BAD_REQUEST.value());
        error.setErrorMessage(ex.getMessage());
        return new ResponseEntity<DtoApiError>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<DtoApiError> exceptionNullPointerHandler(Exception ex){
        DtoApiError error = new DtoApiError(500, ex.getMessage());
        return new ResponseEntity<DtoApiError>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<DtoApiError> exceptionIllegalArgumentSizeHandler (Exception ex){
        DtoApiError error = new DtoApiError(500, ex.getMessage());
        return new ResponseEntity<DtoApiError>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
