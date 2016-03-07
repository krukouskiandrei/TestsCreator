package by.krukouski.testscreator.exception;

import java.io.IOException;

/**
 * Created by Krukouski Andrei on 09.12.2015.
 */
public class ResourceIOException extends IOException {

    public ResourceIOException(){
        super();
    }

    public ResourceIOException(String message, Throwable cause){
        super(message, cause);
    }

    public ResourceIOException(String message){
        super(message);
    }

    public ResourceIOException(Throwable cause){
        super(cause);
    }


}
