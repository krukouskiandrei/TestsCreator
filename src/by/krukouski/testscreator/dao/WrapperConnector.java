package by.krukouski.testscreator.dao;


import by.krukouski.testscreator.exception.ResourceSQLException;
import org.apache.log4j.Logger;


import java.sql.*;

/**
 * Created by Krukouski Andrei on 27.12.2015.
 */
public class WrapperConnector {

    static Logger logger = Logger.getLogger(WrapperConnector.class);

    private Connection connection;
    public WrapperConnector(Connection connection){
        this.connection = connection;
    }
    public Statement getStatement() throws SQLException{
        if(connection != null){
            Statement statement = connection.createStatement();
            if(statement != null)
                return statement;
        }
        logger.error("connection or statement is null");
        throw new ResourceSQLException("connection or statement is null");
    }
    public PreparedStatement getPreparedStatement(String sql) throws SQLException{
        if(connection != null){
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            if(preparedStatement != null)
                return preparedStatement;
        }
        logger.error("connection or preparedStatement is null");
        throw new ResourceSQLException("connection or preparedStatement is null");
    }
    public void closeStatement(Statement statement){
        if(statement != null){
            try {
                statement.close();
            }catch (SQLException e){
                logger.error(e.getMessage());
            }
        }
    }
    /*public void closeConnection(){
        if(connection != null){
            try {
                DataSource.returnConnection(connection);
                connection.close();
            }catch (SQLException e){
                logger.error(e.getMessage());
            }
        }
    }*/

}
