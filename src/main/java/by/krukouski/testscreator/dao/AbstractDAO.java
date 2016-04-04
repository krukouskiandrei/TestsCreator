package by.krukouski.testscreator.dao;

import by.krukouski.testscreator.exception.DAOException;
import by.krukouski.testscreator.subject.Entity;


import java.sql.Statement;
import java.util.List;

/**
 * Created by Krukouski Andrei on 27.12.2015.
 */
public abstract class AbstractDAO <K, T extends Entity> {//К - key in table

    protected WrapperConnector connector;

    public abstract List<T> findAll() throws DAOException;
    public abstract T findEntityById(K id) throws DAOException;
    public abstract boolean delete(K id);
    public abstract boolean delete(T entity) throws DAOException;
    public abstract boolean create(T entity) throws DAOException;
    public abstract boolean update(T entity) throws DAOException;
    public void close(){
        ConnectionExtract.returnConnection(connector);
    }
    protected void closeStatement(Statement statement){
        connector.closeStatement(statement);
    }

}
