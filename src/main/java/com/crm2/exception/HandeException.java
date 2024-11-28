package com.crm2.exception;

import com.crm2.Payload.ErrorDetails;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

//in this class it handle global exceptions
@ControllerAdvice
public class HandeException {
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDetails> GlobalException(Exception e, WebRequest request){
        ErrorDetails errorDetails = new ErrorDetails(
                e.getMessage(),
                new Date()
                //webrequest help send client info
                ,request.getDescription(false));
        return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
