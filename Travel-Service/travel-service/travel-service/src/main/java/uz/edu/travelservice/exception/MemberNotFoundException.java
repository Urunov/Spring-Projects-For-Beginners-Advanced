package uz.edu.travelservice.exception;

/**
 * Created By hamdamboy
 * Project: spring-university-project
 * Date: 04/10/22
 * Email: hamdamboy.urunov@gmail.com
 */

public class MemberNotFoundException extends Exception {
    //


    public MemberNotFoundException() {
        super();
    }

    public MemberNotFoundException(String message) {
        super(message);
    }

    public MemberNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public MemberNotFoundException(Throwable cause) {
        super(cause);
    }

    protected MemberNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
