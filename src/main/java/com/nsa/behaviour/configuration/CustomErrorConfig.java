package com.nsa.behaviour.configuration;

import com.nsa.behaviour.controllers.PatientRestController;
import com.nsa.behaviour.entities.Patient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by c1673342 on 09/05/2018.
 */
@ControllerAdvice
@RestController
public class CustomErrorConfig extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<ErrorDetails> handleAllExceptions(Exception ex, WebRequest request) {
        ErrorDetails errorDetails = new ErrorDetails(new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date()), ex.getMessage(),
                request.getDescription(false));
        String errorMessage = "Please enter a valid username and password";

        return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);

    }

    @ExceptionHandler(UserNotFoundException.class)
    public final ResponseEntity<ErrorDetails> handleUserNotFoundException(UserNotFoundException ex, WebRequest request) {
       ErrorDetails errorDetails = new ErrorDetails((new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date())), ex.getMessage(),
                request.getDescription(false));
        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }

}
