package uz.edu.travelservice.exception;

/**
 * Created By hamdamboy
 * Project: spring-demo-start
 * Date: 24/09/22
 * Email: hamdamboy.urunov@gmail.com
 */

public class TravelClubNotFoundException extends Exception {

    /**
     *
     * Need to Override method (of Exception)
     * 1. All method (6 methods)
     * 2. Using in the entire code of the Student
     * */
    public TravelClubNotFoundException() {
        super();
    }

    public TravelClubNotFoundException(String message) {
        super(message);
    }

    public TravelClubNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public TravelClubNotFoundException(Throwable cause) {
        super(cause);
    }

    protected TravelClubNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
