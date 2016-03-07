package by.krukouski.testscreator.dao;

import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Krukouski Andrei on 07.03.2016.
 */
//Connectio Pool Class
public class ConnectionPool {

    static Logger logger = Logger.getLogger(ConnectionPool.class);

    //array list to hold the connections
    List<Connection> availableConnections = new ArrayList<Connection>();
    //initialize the connection pool
    public ConnectionPool(){
        initializeConnectionPool();
    }
    //initialize the connection pool
    private void initializeConnectionPool(){
        while (!checkIfConnectionPoolIsFull()){
            availableConnections.add(createNewConnectionForPool());
        }
    }
    //check the connection pool is full and if pool is empty then add new connection
    private synchronized boolean checkIfConnectionPoolIsFull(){
        final int MAX_POOL_SIZE = Configuration.getInstance().DB_MAX_CONNECTIONS;

        if(availableConnections.size() < MAX_POOL_SIZE){
            return false;
        }

        return true;
    }
    //get the database configuration from Configuration.java and create new connection
    private Connection createNewConnectionForPool(){
        Configuration config = Configuration.getInstance();

        try{
            Class.forName(config.DB_DRIVER);
            Connection connection = (Connection) DriverManager.getConnection(config.DB_URL, config.DB_USER_NAME, config.DB_PASSWORD);
            return connection;
        }catch (ClassNotFoundException | SQLException e){
            logger.error(e.getMessage());
        }
        return null;
    }
    //get the connetion from connetion pool
    public synchronized Connection getConnectionFromPool(){
        Connection connection = null;
        if(availableConnections.size() > 0){
            connection = (Connection) availableConnections.get(0);
            availableConnections.remove(0);
        }
        return connection;
    }
    //return the connetion to connection pool
    public synchronized void returnConnectionToPool(Connection connection){
        availableConnections.add(connection);
    }
}
