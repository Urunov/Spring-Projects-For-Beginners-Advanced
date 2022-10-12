package uz.edu.travelservice.exception;

/**
 * Created By hamdamboy
 * Project: Spring-travel-Project
 * Date: 06/10/22
 * Email: hamdamboy.urunov@gmail.com
 */
public class MembershipNotFoundException extends Exception{
    //
    // Override

    public MembershipNotFoundException() {
        super();
    }

    public MembershipNotFoundException(String message) {
        super(message);
    }

    public MembershipNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public MembershipNotFoundException(Throwable cause) {
        super(cause);
    }

    protected MembershipNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
