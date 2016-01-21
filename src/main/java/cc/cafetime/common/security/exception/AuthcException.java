package cc.cafetime.common.security.exception;

/**
 * Created by liujing on 16/1/21.
 */
public class AuthcException extends Exception {

    public AuthcException(){
        super();
    }

    public AuthcException(String msg){
        super(msg);
    }

    public AuthcException(String msg, Throwable cause){
        super(msg, cause);
    }

    public AuthcException(Throwable cause){
        super(cause);
    }
}
