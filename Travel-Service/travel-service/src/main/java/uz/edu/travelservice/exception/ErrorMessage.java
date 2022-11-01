package uz.edu.travelservice.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

/**
 * @project: spring-university-project
 * @Date: 06.10.2022
 * @author: H_Urunov
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ErrorMessage {
    //
    private HttpStatus status; // Protocol status (Rest)
    private String message; // message --> sobsheniya
}
