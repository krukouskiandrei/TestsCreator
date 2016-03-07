package by.krukouski.testscreator.exception;

/**
 * Created by Krukouski Andrei on 27.12.2015.
 */
public class ResourceUnsupportedOperationExeption extends UnsupportedOperationException {

    public ResourceUnsupportedOperationExeption(){
        super();
    }

    public ResourceUnsupportedOperationExeption(String message, Throwable cause){
        super(message, cause);
    }

    public ResourceUnsupportedOperationExeption(String message){
        super(message);
    }

    public ResourceUnsupportedOperationExeption(Throwable cause){
        super(cause);
    }

}
