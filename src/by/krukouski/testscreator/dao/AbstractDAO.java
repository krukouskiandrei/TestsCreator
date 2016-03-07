package by.krukouski.testscreator.dao;

import by.krukouski.testscreator.subject.Entity;


import java.sql.Statement;
import java.util.List;

/**
 * Created by Krukouski Andrei on 27.12.2015.
 */
public abstract class AbstractDAO <K, T extends Entity> {//К - key in table

    protected WrapperConnector connector;

    public abstract List<T> findAll();
    public abstract T findEntityById(K id);
    public abstract boolean delete(K id);
    public abstract boolean delete(T entity);
    public abstract boolean create(T entity);
    public abstract T update(T entity);
    public void close(){
        connector.closeConnection();
    }
    protected void closeStatement(Statement statement){
        connector.closeStatement(statement);
    }

}
