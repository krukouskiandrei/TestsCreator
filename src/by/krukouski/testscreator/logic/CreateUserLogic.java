package by.krukouski.testscreator.logic;

import by.krukouski.testscreator.dao.UserDAO;
import by.krukouski.testscreator.subject.User;

/**
 * Created by Krukouski Andrei on 08.01.2016.
 */
public class CreateUserLogic {

    public int createUser(User user){

        UserDAO userDAO = new UserDAO();
        User userLogin = userDAO.findUserByLogin(user.getLogin());
        if(userLogin.getLogin() != null)
            return 0;
        User userPassword = userDAO.findUserByPassword(user.getPassword());
        if (userPassword.getLogin() != null)
            return -1;
        userDAO.create(user);
        userDAO.close();
        return 1;

    }

}
