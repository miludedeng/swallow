package cc.cafetime.common.security.exception;

/**
 * Created by liujing on 16/1/21.
 */
public class AuthzException extends Exception {

    public AuthzException(){
        super();
    }

    public AuthzException(String msg){
        super(msg);
    }

    public AuthzException(String msg, Throwable cause){
        super(msg, cause);
    }

    public AuthzException(Throwable cause){
        super(cause);
    }
}
