package uz.edu.be.spring.university.project.exception;

/**
 * Created By hamdamboy
 * Project: spring-demo-start
 * Date: 24/09/22
 * Email: hamdamboy.urunov@gmail.com
 */

public class StudentNotFoundException extends Exception {

    /**
     *
     * Need to Override method (of Exception)
     * 1. All method
     * 2. Using in the entire code of the Student
     * */
    public StudentNotFoundException() {
        super();
    }

    public StudentNotFoundException(String message) {
        super(message);
    }

    public StudentNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public StudentNotFoundException(Throwable cause) {
        super(cause);
    }

    protected StudentNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
