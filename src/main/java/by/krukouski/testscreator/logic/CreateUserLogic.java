package by.krukouski.testscreator.logic;

import by.krukouski.testscreator.dao.UserDAO;
import by.krukouski.testscreator.exception.UserDAOException;
import by.krukouski.testscreator.subject.User;
import org.apache.log4j.Logger;

/**
 * Created by Krukouski Andrei on 08.01.2016.
 */
public class CreateUserLogic {
    static Logger logger = Logger.getLogger(CreateUserLogic.class);
    public static int createUser(User user){

        UserDAO userDAO = new UserDAO();
        if(userDAO.findUserByLogin(user.getLogin()).getLogin() != null){
            return 0;
        }
        if(userDAO.findUserByPassword(user.getPassword()).getPassword() != null){
            return -1;
        }
        userDAO.create(user);
        userDAO.close();
        return 1;


    }

}
