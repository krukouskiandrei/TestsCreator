package by.krukouski.testscreator.logic;

import by.krukouski.testscreator.dao.UserDAO;
import by.krukouski.testscreator.subject.User;

import java.util.List;

/**
 * Created by Krukouski Andrei on 15.03.2016.
 */
public class ShowUserLogic {

    public List<User> showAllUsers(){
        UserDAO userDAO = new UserDAO();
        List<User> users = userDAO.findAll();
        userDAO.close();
        return users;
    }

}
