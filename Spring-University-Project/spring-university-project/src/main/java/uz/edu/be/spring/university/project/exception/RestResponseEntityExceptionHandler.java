package uz.edu.be.spring.university.project.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import uz.edu.be.spring.university.project.model.entity.ErrorMessage;

import java.util.Date;


/**
 * @project: spring-university-project
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

    // Handle Specific Exception.
    @ExceptionHandler(StudentNotFoundException.class)
    public ResponseEntity<ErrorMessage> studentNotFoundException(StudentNotFoundException exception,
                                                                 WebRequest request){
        ErrorMessage message = new ErrorMessage(HttpStatus.NOT_FOUND, exception.getMessage()); // 1. Error Message for capture error
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);

    }
    //Handle specific exception.
    @ExceptionHandler(UniversityNotFoundException.class)
    public ResponseEntity<?> universityNotFoundException(UniversityNotFoundException exception,
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
    public ResponseEntity<?> handleGlobalException(Exception exception, WebRequest request){


        Date messageTime = new Date();

        ErrorDetails errorDetails = new ErrorDetails(messageTime, exception.getMessage(), request); //
        return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
