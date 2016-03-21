package by.krukouski.testscreator.logic;

import by.krukouski.testscreator.dao.UserDAO;
import by.krukouski.testscreator.exception.UserDAOException;
import by.krukouski.testscreator.subject.User;

/**
 * Created by Krukouski Andrei on 09.12.2015.
 */
public class LoginLogic {
    //checking login and password
    public User checkLogin(String enterLogin, String enterPassword) {

        try {
            UserDAO userDAO = new UserDAO();
            User user = userDAO.findUserByLogin(enterLogin);
            userDAO.close();
            if (!user.getPassword().equals(enterPassword)) {
                return null;
            }
            return user;
        }catch (UserDAOException e){
            return null;
        }
    }

}
