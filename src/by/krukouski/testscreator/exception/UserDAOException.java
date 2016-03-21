package by.krukouski.testscreator.exception;

/**
 * Created by Krukouski Andrei on 16.03.2016.
 */
public class UserDAOException extends DAOException {

    public UserDAOException(){
        super();
    }

    public UserDAOException(String message, Throwable cause){
        super(message, cause);
    }

    public UserDAOException(String message){
        super(message);
    }

    public UserDAOException(Throwable cause){
        super(cause);
    }

}
