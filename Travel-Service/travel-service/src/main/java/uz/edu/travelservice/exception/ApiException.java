package uz.edu.travelservice.exception;

/**
 * @project: spring-university-project
 * @Date: 06.10.2022
 * @author: H_Urunov
 **/

public class ApiException extends RuntimeException {
    //
    private static final long serialVersionUID = 1L;

    public ApiException(String message){
        super(message);
    }
}
