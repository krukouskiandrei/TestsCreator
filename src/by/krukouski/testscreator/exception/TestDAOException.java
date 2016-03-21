package by.krukouski.testscreator.exception;

import com.sun.rmi.rmid.ExecOptionPermission;

/**
 * Created by Krukouski Andrei on 16.03.2016.
 */
public class TestDAOException extends DAOException {

    public TestDAOException(){
        super();
    }

    public TestDAOException(String message, Throwable cause){
        super(message, cause);
    }

    public TestDAOException(String message){
        super(message);
    }

    public TestDAOException(Throwable cause){
        super(cause);
    }


}
