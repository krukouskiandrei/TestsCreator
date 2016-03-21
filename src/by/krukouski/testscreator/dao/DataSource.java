package by.krukouski.testscreator.dao;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by Krukouski Andrei on 07.03.2016.
 */
//class to get the connetion and return the connetion with ConnetionPool.class
public class DataSource {

    static ConnectionPool pool = new ConnectionPool();
    //get the connetion with Pool
    public static WrapperConnector getConnection() throws ClassNotFoundException, SQLException{
        WrapperConnector connection = pool.getConnectionFromPool();
        return connection;
    }
    //return the connetion to Pool
    public static void returnConnection(WrapperConnector connection){
        pool.returnConnectionToPool(connection);
    }

}
