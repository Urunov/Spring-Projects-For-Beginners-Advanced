package uz.edu.be.spring.university.project.exception;

/**
 * Created By hamdamboy
 * Project: spring-university-project
 * Date: 04/10/22
 * Email: hamdamboy.urunov@gmail.com
 */

public class UniversityNotFoundException extends Exception {
    //


    public UniversityNotFoundException() {
        super();
    }

    public UniversityNotFoundException(String message) {
        super(message);
    }

    public UniversityNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public UniversityNotFoundException(Throwable cause) {
        super(cause);
    }

    protected UniversityNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
