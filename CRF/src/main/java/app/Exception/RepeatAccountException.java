package app.Exception;

/**
 * Created by 52400 on 2017/6/20.
 */
public class RepeatAccountException extends RuntimeException {
    public RepeatAccountException(String msg) {
        super(msg);
    }
}
