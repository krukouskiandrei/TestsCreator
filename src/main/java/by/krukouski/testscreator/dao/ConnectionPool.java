package by.krukouski.testscreator.dao;

import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Krukouski Andrei on 07.03.2016.
 */
//Connectio Pool Class
public class ConnectionPool {

    static Logger logger = Logger.getLogger(ConnectionPool.class);

    //array list to hold the connections
    final int MAX_POOL_SIZE = SettingDB.getInstance().DB_MAX_CONNECTIONS;
    private BlockingQueue<WrapperConnector> availableConnections = new ArrayBlockingQueue<WrapperConnector>(MAX_POOL_SIZE);
    private static ReentrantLock lock = new ReentrantLock();
    //initialize the connection pool
    ConnectionPool(){
        initializeConnectionPool();
    }
    //initialize the connection pool
    private void initializeConnectionPool(){
        while (!checkIfConnectionPoolIsFull()){
            try {
                SettingDB config = SettingDB.getInstance();
                Class.forName(config.DB_DRIVER);
                availableConnections.offer(createNewConnectionForPool(config));
            }catch (ClassNotFoundException e){
                logger.error(e.getMessage());
            }
        }
    }
    //check the connection pool is full and if pool is empty then add new connection
    private synchronized boolean checkIfConnectionPoolIsFull(){
        lock.lock();
        try {
            if (availableConnections.size() < MAX_POOL_SIZE) {
                return false;
            }
        }finally {
            lock.unlock();
        }
        return true;
    }
    //get the database configuration from SettingDB.java and create new connection
    private WrapperConnector createNewConnectionForPool(SettingDB config){
        try{
            WrapperConnector connection = new WrapperConnector((Connection) DriverManager.getConnection(config.DB_URL,
                    config.DB_USER_NAME, config.DB_PASSWORD));
            return connection;
        }catch (SQLException e){
            logger.error(e.getMessage());
            throw new RuntimeException(e);
        }
    }
    //get the connetion from connetion pool
    public WrapperConnector getConnectionFromPool(){
        WrapperConnector connection = null;
        if(availableConnections.size() > 0){
            connection = (WrapperConnector) availableConnections.remove();
        }
        return connection;
    }
    //return the connetion to connection pool
    public void returnConnectionToPool(WrapperConnector connection){
        availableConnections.offer(connection);
    }
}
