package by.krukouski.testscreator.dao;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by Krukouski Andrei on 07.03.2016.
 */
//class to get the connetion and return the connetion with ConnetionPool.class
 class ConnectionExtract {

    static ConnectionPool pool = new ConnectionPool();
    //get the connetion with Pool
     static WrapperConnector getConnection(){
        WrapperConnector connection = pool.getConnectionFromPool();
        return connection;
    }
    //return the connetion to Pool
     static void returnConnection(WrapperConnector connection){
        pool.returnConnectionToPool(connection);
    }

}
