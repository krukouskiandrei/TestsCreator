package by.bsu.krukouski.testscreator.bd;

import by.bsu.krukouski.testscreator.exception.ResourceException;
import by.bsu.krukouski.testscreator.exception.ResourceUnsupportedOperationExeption;
import by.bsu.krukouski.testscreator.exception.ResourceSQLExeption;
import by.bsu.krukouski.testscreator.subject.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Krukouski Andrei on 27.12.2015.
 */
public class UserDAO extends AbstractDAO<Integer, User> {

    public static final String SQL_SELECT_ALL_USERS = "SELECT * FROM user";//вобор всех пользователей
    public static final String SQL_SELECT_USER_BY_LOGIN = "SELECT * FROM user WHERE login = ?";//вобор пользователя по логину
    public static final String SQL_SELECT_USER_BY_PASSWORD = "SELECT * FROM user WHERE password = ?";//выбор пользователя по паролю
    public static final String SQL_INSERT_USER = "INSERT INTO user(lastname, firstname, email, login, password) VALUES(?, ?, ?, ?, ?)";//вставка пользователя
    public static final String SQL_INSERT_STATISTIC_BY_USER = "INSERT INTO statistic(id_user, take_tests, right_tests) VALUES(?, ?, ?)";//создание таблицы "статистика" для полизователя
    public static final String SQL_SELECT_IDUSER_BY_LOGIN = "SELECT id FROM user WHERE login = ?";//выбор id пользователя по его логину
    public UserDAO(){
        this.connector = new WrapperConnector();
    }
    @Override
    public List<User> findAll(){//получение всех пользователей из БД
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
            new ResourceSQLExeption(e);
        }catch (Exception e){
            new ResourceException(e);
        }finally {
            this.closeStatement(statement);
        }
        return users;
    }
    public User findUserByLogin(String login){//нахождение пользователя по логину
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
            new ResourceSQLExeption(e);
        }catch  (Exception e){
            new ResourceException(e);
        }finally {
            this.closeStatement(statement);
        }
        return user;
    }
    public User findUserByPassword(String password){//нахождение пользователя по паролю
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
            new ResourceSQLExeption(e);
        }catch  (Exception e){
            new ResourceException(e);
        }finally {
            this.closeStatement(statement);
        }
        return user;
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
    public boolean create(User user){//вставка пользователя в БД
        PreparedStatement statement = null;
        try{
            statement = connector.getPreparedStatement(SQL_INSERT_USER);
            statement.setString(1, user.getLastname());
            statement.setString(2, user.getFirstname());
            statement.setString(3, user.getEmail());
            statement.setString(4, user.getLogin());
            statement.setString(5, user.getPassword());
            statement.executeUpdate();
            statement = connector.getPreparedStatement(SQL_SELECT_IDUSER_BY_LOGIN);
            statement.setString(1, user.getLogin());
            ResultSet resultSet = statement.executeQuery();
            resultSet.next();
            user.setId(resultSet.getInt("id"));
            statement = connector.getPreparedStatement(SQL_INSERT_STATISTIC_BY_USER);
            statement.setInt(1, user.getId());
            statement.setInt(2, 0);
            statement.setInt(3, 0);
            statement.executeUpdate();

        }catch (SQLException e){
            new ResourceSQLExeption(e);
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
