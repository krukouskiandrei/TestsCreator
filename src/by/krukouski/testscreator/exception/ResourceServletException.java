package by.krukouski.testscreator.exception;

import javax.servlet.ServletException;

/**
 * Created by Krukouski Andrei on 08.12.2015.
 */
public class ResourceServletException extends ServletException {

    public ResourceServletException(){
        super();
    }

    public ResourceServletException(String message, Throwable cause){
        super(message, cause);
    }

    public ResourceServletException(String message){
        super(message);
    }

    public ResourceServletException(Throwable cause){
        super(cause);
    }


}
