package uz.edu.be.spring.university.project.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import uz.edu.be.spring.university.project.model.entity.ErrorMessage;

/**
 * @project: spring-university-project
 * @Date: 06.10.2022
 * @author: H_Urunov
 **/

@ControllerAdvice
@ResponseStatus
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {
    //
    @ExceptionHandler(StudentNotFoundException.class)
    public ResponseEntity<ErrorMessage> studentNotFoundException(StudentNotFoundException exception,
                                                                 WebRequest request){
        ErrorMessage message = new ErrorMessage(HttpStatus.NOT_FOUND, exception.getMessage());


        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                 .body(message);
    }

    @ExceptionHandler(UniversityNotFoundException.class)
    public ResponseEntity<ErrorMessage> universityNotFoundException(UniversityNotFoundException exception,
                                                                 WebRequest request){
        ErrorMessage message = new ErrorMessage(HttpStatus.NOT_FOUND, exception.getMessage());


        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(message);
    }
}
