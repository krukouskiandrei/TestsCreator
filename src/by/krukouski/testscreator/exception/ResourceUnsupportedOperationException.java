package by.krukouski.testscreator.exception;

/**
 * Created by Krukouski Andrei on 27.12.2015.
 */
public class ResourceUnsupportedOperationException extends UnsupportedOperationException {

    public ResourceUnsupportedOperationException(){
        super();
    }

    public ResourceUnsupportedOperationException(String message, Throwable cause){
        super(message, cause);
    }

    public ResourceUnsupportedOperationException(String message){
        super(message);
    }

    public ResourceUnsupportedOperationException(Throwable cause){
        super(cause);
    }

}
