package uz.edu.travelservice.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

/**
 * @project: spring-university-project
 * @Date: 06.10.2022
 * @author: H_Urunov
 **/
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ErrorDetails {
    //
    private Date timestamp;
    private String message; // sobsheniya
    private String details;

    public ErrorDetails(Date messageTime, String message, WebRequest request) {
    }
}
