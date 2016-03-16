package by.krukouski.testscreator.dao;


import by.krukouski.testscreator.exception.ResourceUnsupportedOperationExeption;
import by.krukouski.testscreator.exception.ResourceSQLExeption;
import by.krukouski.testscreator.subject.Statistic;
import by.krukouski.testscreator.subject.User;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Krukouski Andrei on 27.12.2015.
 */
public class UserDAO extends AbstractDAO<Integer, User> {

    static Logger logger = Logger.getLogger(UserDAO.class);

    public static final String SQL_SELECT_ALL_USERS = "SELECT id, firstname, lastname, email, login, password, admin FROM user WHERE admin = 0";//select all users
    public static final String SQL_SELECT_USER_BY_LOGIN = "SELECT id, firstname, lastname, email, login, password, admin FROM user WHERE login = ?";//select user by login
    public static final String SQL_SELECT_USER_BY_PASSWORD = "SELECT id, firstname, lastname, email, login, password, admin FROM user WHERE password = ?";//select user by password
    public static final String SQL_INSERT_USER = "INSERT INTO user(lastname, firstname, email, login, password) VALUES(?, ?, ?, ?, ?)";//insert user
    public static final String SQL_INSERT_STATISTIC_BY_USER = "INSERT INTO statistic(id_user, name_test, score, time) VALUES(?, ?, ?, ?)";//creating statistic table for user
    public static final String SQL_SELECT_IDUSER_BY_LOGIN = "SELECT id FROM user WHERE login = ?";//select user id by uset login
    public static final String SQL_SELECT_STATISTICS_USER = "SELECT name_test,score, time FROM statistic WHERE id_user = ?";//select all user statistics by id user
    public UserDAO(){
        this.connector = new WrapperConnector();
    }
    @Override
    public List<User> findAll(){//get list all users
        List<User> users = new ArrayList<>();
        Statement statement = null;
        try {
            statement = connector.getStatement();
            ResultSet resultSet = statement.executeQuery(SQL_SELECT_ALL_USERS);
            while (resultSet.next()){
                User user = new User();
                user.setId(resultSet.getInt("id"));
                user.setFirstname(resultSet.getString("firstname"));
                user.setLastname(resultSet.getString("lastname"));
                user.setEmail(resultSet.getString("email"));
                user.setLogin(resultSet.getString("login"));
                user.setPassword(resultSet.getString("password"));
                user.setAdmin(resultSet.getBoolean("admin"));
                users.add(user);
            }
        }catch (SQLException e){
            logger.error(e.getMessage());
        }finally {
            this.closeStatement(statement);
        }
        return users;
    }
    public Integer findUserId(String login){
        Integer idUser = null;
        PreparedStatement statement = null;
        try {
            statement = connector.getPreparedStatement(SQL_SELECT_IDUSER_BY_LOGIN);
            statement.setString(1, login);
            ResultSet resultSet = statement.executeQuery();
            resultSet.next();
            idUser = resultSet.getInt("id");
        }catch (SQLException e){
            logger.error(e.getMessage());
        }finally {
            this.closeStatement(statement);
        }
        return idUser;
    }

    public User findUserByLogin(String login){//searching user by login
        User user = new User();
        PreparedStatement statement = null;
        try {
            statement = connector.getPreparedStatement(SQL_SELECT_USER_BY_LOGIN);
            statement.setString(1, login);
            ResultSet resultSet = statement.executeQuery();
            resultSet.next();
            user.setId(resultSet.getInt("id"));
            user.setFirstname(resultSet.getString("firstname"));
            user.setLastname(resultSet.getString("lastname"));
            user.setEmail(resultSet.getString("email"));
            user.setLogin(resultSet.getString("login"));
            user.setPassword(resultSet.getString("password"));
            user.setAdmin(resultSet.getBoolean("admin"));

        }catch (SQLException e){
            logger.error(e.getMessage());
        }finally {
            this.closeStatement(statement);
        }
        return user;
    }
    public User findUserByPassword(String password){//searching user by password
        User user = new User();
        PreparedStatement statement = null;
        try {
            statement = connector.getPreparedStatement(SQL_SELECT_USER_BY_PASSWORD);
            statement.setString(1, password);
            ResultSet resultSet = statement.executeQuery();
            resultSet.next();
            user.setId(resultSet.getInt("id"));
            user.setFirstname(resultSet.getString("firstname"));
            user.setLastname(resultSet.getString("lastname"));
            user.setEmail(resultSet.getString("email"));
            user.setLogin(resultSet.getString("login"));
            user.setPassword(resultSet.getString("password"));
            user.setAdmin(resultSet.getBoolean("admin"));

        }catch (SQLException e){
            logger.error(e.getMessage());
        }finally {
            this.closeStatement(statement);
        }
        return user;
    }
    public List<Statistic> findUserStatistics(Integer idUser){
        List<Statistic> statistics = new ArrayList<>();
        PreparedStatement statement = null;
        try {
            statement = connector.getPreparedStatement(SQL_SELECT_STATISTICS_USER);
            statement.setString(1, idUser.toString());
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                Statistic statistic = new Statistic();
                statistic.setNameTest(resultSet.getString("name_test"));
                statistic.setScore(new Integer(resultSet.getString("score")));
                statistic.setTime(resultSet.getString("time"));
                statistics.add(statistic);
            }
        }catch (SQLException e){
            logger.error(e.getMessage());
        }finally {
            this.closeStatement(statement);
        }
        return statistics;
    }

    @Override
    public User findEntityById(Integer id){
        throw new ResourceUnsupportedOperationExeption();
    }
    @Override
    public boolean delete(Integer id){
        throw new ResourceUnsupportedOperationExeption();
    }
    @Override
    public boolean delete(User user){
        throw new ResourceUnsupportedOperationExeption();
    }
    @Override
    public boolean create(User user){//insert user in database
        PreparedStatement statement = null;
        try{
            statement = connector.getPreparedStatement(SQL_INSERT_USER);
            statement.setString(1, user.getLastname());
            statement.setString(2, user.getFirstname());
            statement.setString(3, user.getEmail());
            statement.setString(4, user.getLogin());
            statement.setString(5, user.getPassword());
            statement.executeUpdate();
            /*statement = connector.getPreparedStatement(SQL_SELECT_IDUSER_BY_LOGIN);
            statement.setString(1, user.getLogin());
            ResultSet resultSet = statement.executeQuery();
            resultSet.next();
            user.setId(resultSet.getInt("id"));
            statement = connector.getPreparedStatement(SQL_INSERT_STATISTIC_BY_USER);
            statement.setInt(1, user.getId());
            statement.setInt(2, 0);
            statement.setInt(3, 0);
            statement.executeUpdate();*/

        }catch (SQLException e){
            logger.error(e.getMessage());
            return false;
        }finally {
            this.closeStatement(statement);
        }
        return true;
    }

    public boolean createStatisticTabel(Integer idUser, Statistic statistic){
        PreparedStatement statement = null;
        try{
            statement = connector.getPreparedStatement(SQL_INSERT_STATISTIC_BY_USER);
            statement.setString(1, idUser.toString());
            statement.setString(2, statistic.getNameTest());
            statement.setString(3, statistic.getScore().toString());
            statement.setString(4, statistic.getTime());
            statement.executeUpdate();
        }catch (SQLException e){
            logger.error(e.getMessage());
            return false;
        }finally {
            this.closeStatement(statement);
        }


        return true;
    }

    @Override
    public User update(User user){
        throw new ResourceUnsupportedOperationExeption();
    }


}
