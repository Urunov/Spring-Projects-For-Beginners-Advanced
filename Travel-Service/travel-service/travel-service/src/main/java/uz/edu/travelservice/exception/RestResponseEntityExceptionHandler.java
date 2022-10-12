package uz.edu.travelservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;


/**
 * @project: spring-travel-project
 * @Date: 06.10.2022
 * @author: H_Urunov
 **/

@ControllerAdvice
@ResponseStatus
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {
    //
    /***
     * 1. Handle specific Exception.
     * 2. Handle Global Exception.
     *
     * **/

    // Handle Specific Exception. (Student)
    @ExceptionHandler(TravelClubNotFoundException.class)
    public ResponseEntity<?> studentNotFoundException(TravelClubNotFoundException exception,
                                                      WebRequest request){
        // 1. Step. Error Message handler.
//        ErrorMessage message1 = new ErrorMessage(HttpStatus.NOT_FOUND, exception.getMessage()); // 1. Error Message for capture error
//        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message1);
//
        // 2. Step. Error Details.
//        Date messageTime = new Date();
        ErrorDetails errorDetails = new ErrorDetails(new Date(), exception.getMessage(), request.getDescription(true));

        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }


    //Handle specific exception.
    @ExceptionHandler(MemberNotFoundException.class)
    public ResponseEntity<?> universityNotFoundException(MemberNotFoundException exception,
                                                         WebRequest request){

        // 1. Error Message for capture error: Information without date.
//        ErrorMessage message = new ErrorMessage(HttpStatus.NOT_FOUND, exception.getMessage());
//        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);

        // 2. Error Details for capture error.
        Date messageTime = new Date();
        ErrorDetails errorDetails = new ErrorDetails(messageTime, exception.getMessage(), request.getDescription(true));

        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }


    //Handle specific exception.
    @ExceptionHandler(DatabaseNotFoundException.class)
    public ResponseEntity<?> universityNotFoundException(DatabaseNotFoundException exception,
                                                         WebRequest request){

        // 1. Error Message for capture error: Information without date.
//        ErrorMessage message = new ErrorMessage(HttpStatus.NOT_FOUND, exception.getMessage());
//        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);

        // 2. Error Details for capture error.
        Date messageTime = new Date();
        ErrorDetails errorDetails = new ErrorDetails(messageTime, exception.getMessage(), request.getDescription(true));

        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<? extends ErrorDetails> handleGlobalException(Exception exception, WebRequest request){


        Date messageTime = new Date();

        ErrorDetails errorDetails = new ErrorDetails(messageTime, exception.getMessage(), request); //
        return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
