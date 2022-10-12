package uz.edu.travelservice.exception;

/**
 * Created By hamdamboy
 * Project: travel-service
 * Date: 11/10/22
 * Email: hamdamboy.urunov@gmail.com
 */
public class DatabaseNotFoundException extends Exception{
    //

    public DatabaseNotFoundException() {
        super();
    }

    public DatabaseNotFoundException(String message) {
        super(message);
    }

    public DatabaseNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public DatabaseNotFoundException(Throwable cause) {
        super(cause);
    }

    protected DatabaseNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
