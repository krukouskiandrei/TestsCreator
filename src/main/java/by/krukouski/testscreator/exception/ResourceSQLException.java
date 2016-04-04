package by.krukouski.testscreator.exception;

import java.sql.SQLException;

/**
 * Created by Krukouski Andrei on 27.12.2015.
 */
public class ResourceSQLException extends SQLException {

    public ResourceSQLException(){
        super();
    }

    public ResourceSQLException(String message, Throwable cause){
        super(message, cause);
    }

    public ResourceSQLException(String message){
        super(message);
    }

    public ResourceSQLException(Throwable cause){
        super(cause);
    }

}
