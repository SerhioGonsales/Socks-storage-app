package com.lukushin.socks.exception_handling;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<ParameterError> handlerException(
            InvalidRequestParameterException exception){
        ParameterError error = new ParameterError();
        error.setInfo(exception.getMessage());

        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    public ResponseEntity<ParameterError> handlerException(
            NoSuchSocksException exception){
        ParameterError error = new ParameterError();
        error.setInfo(exception.getMessage());

        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    public ResponseEntity<ParameterError> handlerException(
            NotEnoughSocksForDeleteException exception){
        ParameterError error = new ParameterError();
        error.setInfo(exception.getMessage());

        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
}
