package by.krukouski.testscreator.logic;

import by.krukouski.testscreator.dao.UserDAO;
import by.krukouski.testscreator.exception.UserDAOException;
import by.krukouski.testscreator.subject.User;

/**
 * Created by Krukouski Andrei on 08.01.2016.
 */
public class CreateUserLogic {

    public int createUser(User user){

        UserDAO userDAO = new UserDAO();
        try{
            userDAO.findUserByLogin(user.getLogin());
            return 0;
        }catch (UserDAOException e){

        }
        try{
            userDAO.findUserByPassword(user.getPassword());
            return -1;

        }catch (UserDAOException e){
            userDAO.create(user);
            userDAO.close();
            return 1;
        }

    }

}
