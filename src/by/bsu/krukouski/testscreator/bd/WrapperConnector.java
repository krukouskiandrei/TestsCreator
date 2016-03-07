package by.bsu.krukouski.testscreator.bd;

import by.bsu.krukouski.testscreator.exception.ResourceException;
import by.bsu.krukouski.testscreator.exception.ResourceSQLExeption;


import java.sql.*;
import java.util.MissingResourceException;
import java.util.Properties;
import java.util.ResourceBundle;

/**
 * Created by Krukouski Andrei on 27.12.2015.
 */
public class WrapperConnector {

    private Connection connection;
    public WrapperConnector(){
        try {
            ResourceBundle resource = ResourceBundle.getBundle("resources.database");
            String url = resource.getString("db.url");
            String user = resource.getString("db.user");
            String pass = resource.getString("db.password");
            String driver = resource.getString("db.driver");
            Properties properties = new Properties();
            properties.put("user", user);
            properties.put("password", pass);
            Class.forName(driver).newInstance();
            connection = DriverManager.getConnection(url, properties);
        }catch (MissingResourceException e){
            new ResourceException(e);
        }catch (SQLException e){
            System.out.println(e.getMessage());
            System.out.println(e.getErrorCode());
            System.out.println(e.getSQLState());
            new ResourceSQLExeption(e);
        }catch (ClassNotFoundException e){

        }catch (InstantiationException e){

        }catch (IllegalAccessException e){

        }

    }
    public Statement getStatement() throws SQLException{
        if(connection != null){
            Statement statement = connection.createStatement();
            if(statement != null)
                return statement;
        }
        throw new ResourceSQLExeption("connection or statement is null");
    }
    public PreparedStatement getPreparedStatement(String sql) throws SQLException{
        if(connection != null){
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            if(preparedStatement != null)
                return preparedStatement;
        }
        throw new ResourceSQLExeption("connection or preparedStatement is null");
    }
    public void closeStatement(Statement statement){
        if(statement != null){
            try {
                statement.close();
            }catch (SQLException e){
                new ResourceSQLExeption(e);
            }
        }
    }
    public void closeConnection(){
        if(connection != null){
            try {
                connection.close();
            }catch (SQLException e){
                new ResourceSQLExeption(e);
            }
        }
    }

}
