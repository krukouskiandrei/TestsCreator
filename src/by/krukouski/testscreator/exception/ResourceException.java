package by.krukouski.testscreator.exception;

import javax.servlet.ServletException;

/**
 * Created by Krukouski Andrei on 08.12.2015.
 */
public class ResourceException extends Exception {

    public ResourceException(){
        super();
    }

    public ResourceException(String message, Throwable cause){
        super(message, cause);
    }

    public ResourceException(String message){
        super(message);
    }

    public ResourceException(Throwable cause){
        super(cause);
    }




}
