package by.krukouski.testscreator.exception;

/**
 * Created by Krukouski Andrei on 16.03.2016.
 */
public class DAOException extends Exception {

    public DAOException(){
        super();
    }

    public DAOException(String message, Throwable cause){
        super(message, cause);
    }

    public DAOException(String message){
        super(message);
    }

    public DAOException(Throwable cause){
        super(cause);
    }

}
