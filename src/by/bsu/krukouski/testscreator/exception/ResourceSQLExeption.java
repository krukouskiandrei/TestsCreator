package by.bsu.krukouski.testscreator.exception;

import java.sql.SQLException;

/**
 * Created by Krukouski Andrei on 27.12.2015.
 */
public class ResourceSQLExeption extends SQLException {

    public ResourceSQLExeption(){
        super();
    }

    public ResourceSQLExeption(String message, Throwable cause){
        super(message, cause);
    }

    public ResourceSQLExeption(String message){
        super(message);
    }

    public ResourceSQLExeption(Throwable cause){
        super(cause);
    }

}
